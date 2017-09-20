package demo.components.domain;

public class WayPointLocation {

    private double lon;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public WayPointLocation(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }
}
