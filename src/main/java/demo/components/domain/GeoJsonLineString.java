package demo.components.domain;

import java.util.List;

/**
 * This class represents the Java object for geoJson for a LineString,
 */
public class GeoJsonLineString
{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private List<double[]> coordinates;



    public List<double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<double[]> coordinates) {
        this.coordinates = coordinates;
    }

    protected GeoJsonLineString(){}


    public GeoJsonLineString(List<double[]> coordinates) {
        this.coordinates = coordinates;
        this.type = "LineString";
    }

    /**
     * This method reconstructs the String for geoJSON of LineString
     * @return String geoJSON
     */
    @Override
    public String toString(){
        String temp ="[";
        for (int i = 0;i<coordinates.size()-1;i++){
            temp = temp + "["+String.valueOf(coordinates.get(i)[0])+","+String.valueOf(coordinates.get(i)[1])+"]"+",";
        }
        String result = "[" + temp + String.valueOf(coordinates.get(coordinates.size()-1)[0])+ String.valueOf(coordinates.get(coordinates.size()-1)[1])+"]]";
        return "{\"type\":\"LineString\",\"coordinates\":"+result+"}";
    }
}
