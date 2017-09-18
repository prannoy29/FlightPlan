package demo.components.repository;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

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


}
