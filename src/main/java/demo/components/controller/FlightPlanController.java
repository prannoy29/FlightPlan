package demo.components.controller;


import demo.components.domain.FlightPlan;
import demo.components.domain.GeoJsonLineString;
import demo.components.repository.FlightPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
public class FlightPlanController {

   @Autowired
   FlightPlanRepository flightPlanRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/pathMaps", method = RequestMethod.POST)
    public void register(@RequestBody FlightPlan flightPlan) {
        flightPlanRepository.save(flightPlan);
    }

    @RequestMapping(value = "/pathMaps/testOne", method = RequestMethod.GET)
    public GeoJsonLineString testOne() {
        double [] temp = new double[2];
        List mylist = new ArrayList();
        temp[0]=0;
        temp[1]=1;
        mylist.add(temp);
        temp[0]=2;
        temp[1]=3;
        mylist.add(temp);
        GeoJsonLineString geoJsonLineString = new GeoJsonLineString(mylist);
        if(jdbcTemplate !=null)
        {
            System.out.println(jdbcTemplate.getDataSource().toString());
        }
        return geoJsonLineString;
    }

    @RequestMapping(value = "/pathMaps/getElevation", method = RequestMethod.GET)
    public double getElevation(){

       double elevation =  jdbcTemplate.queryForObject("SELECT max(ST_Value(r.rast,foo.pt)) AS val\n" +
               "FROM public.n43e072_50 r\n" +
               "JOIN (SELECT ST_setSRID(ST_GeomFromGeoJSON('{\"type\": \"Point\",\"coordinates\": [-71.3232421875,42.415346114253616]}'),4326)As pt) As foo\n" +
               "ON ST_Intersects(r.rast,foo.pt);",Double.class);

        return elevation;
    }
}
