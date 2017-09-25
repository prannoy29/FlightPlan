package demo.components.dao.impl;

import demo.components.dao.PointDao;
import demo.components.domain.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PointDaoImpl implements PointDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //    public void setJDataSource(DataSource dataSource) {
//        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//    }

    @Override
    public Double getElevation(String geoJsonPoint) {
        if(jdbcTemplate!=null){
            String query = "SELECT max(ST_Value(r.rast,foo.pt)) AS val FROM public.n49w104_500 r JOIN (SELECT ST_setSRID(ST_GeomFromGeoJSON('" +
                    geoJsonPoint + "'),4326)As pt) As foo ON ST_Intersects(r.rast,foo.pt);";
        double elevation =  jdbcTemplate.queryForObject(query,Double.class);

        return elevation;
        }
        else return 0.d;
    }

    @Override
    public List<GeoPoint> getRestrictedPathPoints(String geoJsonLineString, double h1, double h2) {
        String query = "SELECT ST_X((foo.pt).geom) As lon, ST_Y((foo.pt).geom) As lat FROM(SELECT ST_DumpPoints(ST_SetSRID(ST_GeomFromGeoJson('" +
        geoJsonLineString+"'),4326)) AS pt) As foo JOIN public.n49w104_500 r ON ST_Intersects(r.rast,(foo.pt).geom) " +
                "WHERE ST_Value(r.rast,(foo.pt).geom) > " + String.valueOf(h1)+" AND ST_Value(r.rast,(foo.pt).geom) > " +String.valueOf(h2) +";";

        List<GeoPoint> pointsList = jdbcTemplate.queryForList(query,GeoPoint.class);
        return pointsList;
    }

}
