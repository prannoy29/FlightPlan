package demo.components.domain;

/**
 * Created by zemoso on 6/9/17.
 */
public class GeoPoint {
    private double lon;
    private double lat;

    public GeoPoint(double lon, double lat) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
