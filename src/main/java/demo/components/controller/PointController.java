package demo.components.controller;

import demo.components.dao.PointDao;
import demo.components.domain.GeoJsonLineString;
import demo.components.domain.GeoJsonPoint;

import demo.components.domain.GeoPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PointController {
    @Autowired
    PointDao pointDao;

    @RequestMapping(value = "point/getElevation",method = RequestMethod.POST)
    public double getElevation(@RequestBody GeoJsonPoint geoJsonPoint){
        String point = geoJsonPoint.toString();
        double elevation = pointDao.getElevation(point);
        return elevation;
    }

    @RequestMapping(value = "/getRestrictPath",method = RequestMethod.POST)
    public List<GeoPoint> getRestrictPath(@RequestBody GeoJsonLineString geoJsonLineString){
        String queryLine = geoJsonLineString.toString();
        List<GeoPoint> pointsLineList= pointDao.getRestrictedPathPoints(queryLine,3,2);
        return pointsLineList;
    }

}
