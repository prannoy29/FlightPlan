package demo.components.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

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
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "aircraftId",nullable = false)
    private UUID aircraftId;

    public UUID getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(UUID aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Column(name = "contract_id")
    private UUID contractId;

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    @Column(name = "createdAt")
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "createdBy")
    private UUID createdBy;

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "isDeleted",columnDefinition = "boolean default false",nullable = false)
    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Column(name = "modifiedAt")
    private Date modifiedAt;

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Column(name = "modifiedBy")
    private UUID modifiedBy;

    public UUID getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UUID modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name="name",nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "organizationId")
    private UUID organizationId;

    public UUID getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(UUID organizationId) {
        this.organizationId = organizationId;
    }

    @Column(name = "privateId")
    private UUID privateId;

    public UUID getPrivateId() {
        return privateId;
    }

    public void setPrivateId(UUID privateId) {
        this.privateId = privateId;
    }

    @Column
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