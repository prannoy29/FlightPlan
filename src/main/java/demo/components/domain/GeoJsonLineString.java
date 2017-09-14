package demo.components.domain;

import java.util.ArrayList;
import java.util.List;

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
