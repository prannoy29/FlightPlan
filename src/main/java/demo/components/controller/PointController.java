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
    public List<GeoPoint> getRestrictPath(@RequestBody GeoJsonLineString geoJsonLineString,
                                          @RequestParam("h1")double h1,
                                          @RequestParam("h2")double h2){

        String queryLine = geoJsonLineString.toString();
        System.out.println(queryLine);
        List<Double> pointsLineX= pointDao.getRestrictedPathPointsX(queryLine,h1,h2);
        List<Double> pointsLineY= pointDao.getRestrictedPathPointsY(queryLine,h1,h2);
        List<GeoPoint> pointsLineList = new ArrayList<>();
        int i=0;
        while(pointsLineX.size()==pointsLineY.size()&& pointsLineY.size()> i){
            pointsLineList.add(new GeoPoint(pointsLineX.get(i),pointsLineY.get(i)));
            i++;
        }

        return pointsLineList;
    }

}

