package demo.components.repository;

import com.google.gson.Gson;
import demo.components.domain.GeoPoint;
import demo.components.domain.Weather;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.spatial3d.geom.GeoDistance;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.geo.GeoUtils;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.InetAddress;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by zemoso on 18/9/17.
 */
public class WeatherRepository {
    private Client client;

    public WeatherRepository(){
        try {
            Settings settings = Settings.builder().put("cluster.name", "utmregistry").build();
            this.client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("54.173.191.135"), 9300));
        }catch (Exception ex){}
    }

    public GeoPoint getPoint(Double lat,Double lon){
        QueryBuilder qb = geoDistanceQuery("location").point(lat, lon).distance(10, DistanceUnit.KILOMETERS);
        SortBuilder sortBuilder = SortBuilders.geoDistanceSort("location",lat,lon).order(SortOrder.ASC);
        SearchResponse searchResponse = client.prepareSearch("partner_data_us_west")
                                            .setTypes("weather")
                                            .setQuery(qb)
                                            .addSort(sortBuilder)
                                            .execute()
                                            .actionGet();
        SearchHits hits = searchResponse.getHits();
        if(hits.totalHits() == 0){
            throw new NullPointerException("No weather data available at the location");
        }
        else {
            SearchHit hit = hits.getAt(0);
            JSONObject object = new JSONObject(hit.getSource());
            JSONObject object1 = object.getJSONObject("location");
            GeoPoint geoPoint = new GeoPoint(object1.getDouble("lat"),object1.getDouble("lon"));
            return geoPoint;
        }

    }

    public Weather getData(String id){
        //QueryBuilder qb = geoBoundingBoxQuery("location").setCorners(48.08, -103.69, 48.07, -103.70);
        /*QueryBuilder qb = QueryBuilders.matchQuery("id",id);
        SearchResponse searchResponse = client.prepareSearch("partner_data_us_west")
                                              .setTypes("weather")
                                              .setQuery(qb)
                                              .execute()
                                              .actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit hit = hits.getAt(0);*/
        GetResponse response = client.prepareGet("partner_data_us_west","weather",id).get();
        JSONObject object = new JSONObject(response.getSource());
        Weather weather = new Gson().fromJson(object.toString(),Weather.class);
        return weather;
    }

}
