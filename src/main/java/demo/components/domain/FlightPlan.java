package demo.components.domain;

import org.hibernate.annotations.Type;
;
import com.vividsolutions.jts.geom.LineString;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flightPlan")
public class FlightPlan implements Serializable {

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

    public FlightPlan(String geoJsonLineString) {
        this.geoJsonLineString = geoJsonLineString;
    }
}