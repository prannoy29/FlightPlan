package demo.components.domain;

import java.util.Map;
import java.util.UUID;

public class FlightPlanDetails {

    private UUID routeId;

    public UUID getRouteId() {
        return routeId;
    }

    public void setRouteId(UUID routeId) {
        this.routeId = routeId;
    }

    private boolean isWindValid;

    public boolean isWindValid() {
        return isWindValid;
    }

    public void setWindValid(boolean windValid) {
        isWindValid = windValid;
    }

    private double grossWeightLb;

    public double getGrossWeightLb() {
        return grossWeightLb;
    }

    public void setGrossWeightLb(double grossWeightLb) {
        this.grossWeightLb = grossWeightLb;
    }

    private double fuelWeightLb;

    public double getFuelWeightLb() {
        return fuelWeightLb;
    }

    public void setFuelWeightLb(double fuelWeightLb) {
        this.fuelWeightLb = fuelWeightLb;
    }

    private double fuelIndicator;

    public double getFuelIndicator() {
        return fuelIndicator;
    }

    public void setFuelIndicator(double fuelIndicator) {
        this.fuelIndicator = fuelIndicator;
    }

    private double payloadWeightLb;

    public double getPayloadWeightLb() {
        return payloadWeightLb;
    }

    public void setPayloadWeightLb(double payloadWeightLb) {
        this.payloadWeightLb = payloadWeightLb;
    }

    private String flightPlanType;

    public String getFlightPlanType() {
        return flightPlanType;
    }

    public void setFlightPlanType(String flightPlanType) {
        this.flightPlanType = flightPlanType;
    }

    private String flightPlanCategory;

    public String getFlightPlanCategory() {
        return flightPlanCategory;
    }

    private String altitudeMode;

    public String getAltitudeMode() {
        return altitudeMode;
    }

    public void setAltitudeMode(String altitudeMode) {
        this.altitudeMode = altitudeMode;
    }

    public void setFlightPlanCategory(String flightPlanCategory) {
        this.flightPlanCategory = flightPlanCategory;
    }

    private Map<String,Object> props;

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }


    private WayPoints waypointsInfo;

    public WayPoints getWaypointsInfo() {
        return waypointsInfo;
    }

    public void setWaypointsInfo(WayPoints waypointsInfo) {
        this.waypointsInfo = waypointsInfo;
    }

    public FlightPlanDetails(UUID routeId, boolean isWindValid, double grossWeightLb,
                             double fuelWeightLb, double fuelIndicator, double payloadWeightLb,
                             String flightPlanType, String flightPlanCategory, String altitudeMode,
                             Map<String, Object> props, WayPoints waypointsInfo)
    {
        this.routeId = routeId;
        this.isWindValid = isWindValid;
        this.grossWeightLb = grossWeightLb;
        this.fuelWeightLb = fuelWeightLb;
        this.fuelIndicator = fuelIndicator;
        this.payloadWeightLb = payloadWeightLb;
        this.flightPlanType = flightPlanType;
        this.flightPlanCategory = flightPlanCategory;
        this.altitudeMode = altitudeMode;
        this.props = props;
        this.waypointsInfo = waypointsInfo;
    }
}
