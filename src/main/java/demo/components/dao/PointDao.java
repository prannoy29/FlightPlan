package demo.components.dao;

import demo.components.domain.GeoPoint;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface PointDao {
    /**
     * calculates the elevation for a given point on map
     * @param geoJsonPoint geoJson String for a point
     * @return returns double elevation
     */
    Double getElevation(String geoJsonPoint);

    List<Double> getRestrictedPathPointsX(String geoJsonLineString,double h1, double h2);
    List<Double> getRestrictedPathPointsY(String geoJsonLineString,double h1, double h2);
}
