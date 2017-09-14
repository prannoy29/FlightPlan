package demo.components.domain;

public class Elevation {

    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    private double lng;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    private double elevation;

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    protected Elevation() {}

    public Elevation(double lat, double lng, double elevation){
        this.lat = lat;
        this.lng = lng;
        this.elevation = elevation;
    }
}
