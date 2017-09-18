package demo.components.controller;

import demo.components.dao.PointDao;
import demo.components.domain.GeoJsonPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointController {
    @Autowired
    PointDao pointDao;

    @RequestMapping(value = "point/getElevation",method = RequestMethod.POST)
    public double getElevation(@RequestBody GeoJsonPoint geoJsonPoint){

        System.out.println(geoJsonPoint.toString());
        String point = geoJsonPoint.toString();
        double elevation = pointDao.getElevation(point);
        return elevation;
    }

}
