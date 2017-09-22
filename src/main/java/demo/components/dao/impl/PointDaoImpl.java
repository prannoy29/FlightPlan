package demo.components.dao.impl;

import demo.components.dao.PointDao;
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
            System.out.println(geoJsonPoint);
            String query = "SELECT max(ST_Value(r.rast,foo.pt)) AS val FROM public.n49w104_500 JOIN (SELECT ST_setSRID(ST_GeomFromGeoJSON('" +
                    geoJsonPoint + "'),4326)As pt) As foo ON ST_Intersects(r.rast,foo.pt);";
        double elevation =  jdbcTemplate.queryForObject(query,Double.class);

        return elevation;
        }
        else return 0.d;
    }
}
