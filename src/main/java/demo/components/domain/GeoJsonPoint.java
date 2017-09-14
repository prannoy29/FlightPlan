package demo.components.domain;

public class GeoJsonPoint {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private double[] coordinates;

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    protected GeoJsonPoint(){};

    public GeoJsonPoint(double[] coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    @Override
    public String toString(){
        String result = "["+String.valueOf(coordinates[0])+","+String.valueOf(coordinates[1])+"]";
        return "'{\"type\":\"Point\",\"coordinates\":"+result+"}'";
    }
}

