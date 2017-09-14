package demo.components.dao;

import org.springframework.context.annotation.Bean;


public interface PointDao {
    /**
     * calculates the elevation for a given point on map
     * @param geoJsonPoint geoJson String for a point
     * @return returns double elevation
     */
    Double getElevation(String geoJsonPoint);
}
