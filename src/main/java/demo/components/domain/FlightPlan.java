package demo.components.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class represents flightPlan table in gisdb, it has
 * auto generated primary key "id" and String geoJsonLineString
 * which is the string form of geoJson of a LineString
 */
@Entity
@Table(name = "flightPlan")
public class FlightPlan implements Serializable {
    /**
     * declaring unique versionID for this class
     */
    private static final long serialVersionUID = 2342352452451l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "linestring")
    private String geoJsonLineString;

    public String getGeoJsonLineString() {
        return geoJsonLineString;
    }

    public void setGeoJsonLineString(String geoJsonLineString) {
        this.geoJsonLineString = geoJsonLineString;
    }

    protected FlightPlan(){};
    
    public FlightPlan(String geoJsonLineString) {
        this.geoJsonLineString = geoJsonLineString;
    }
}