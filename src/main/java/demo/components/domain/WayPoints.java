package demo.components.domain;

import java.util.Date;
import java.util.Map;

public class WayPoints {

    private double minAltitudeFt;

    public double getMinAltitudeFt() {
        return minAltitudeFt;
    }

    public void setMinAltitudeFt(double minAltitudeFt) {
        this.minAltitudeFt = minAltitudeFt;
    }

    private double maxAltitudeFt;

    public double getMaxAltitudeFt() {
        return maxAltitudeFt;
    }

    public void setMaxAltitudeFt(double maxAltitudeFt) {
        this.maxAltitudeFt = maxAltitudeFt;
    }

    private WayPointLocation wpLocation;

    public WayPointLocation getWpLocation() {
        return wpLocation;
    }

    public void setWpLocation(WayPointLocation wpLocation) {
        this.wpLocation = wpLocation;
    }

    private Date effectiveTimeBegin;

    public Date getEffectiveTimeBegin() {
        return effectiveTimeBegin;
    }

    public void setEffectiveTimeBegin(Date effectiveTimeBegin) {
        this.effectiveTimeBegin = effectiveTimeBegin;
    }

    private Date effectiveTimeEnd;

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    private double minSpeedKn;

    public double getMinSpeedKn() {
        return minSpeedKn;
    }

    public void setMinSpeedKn(double minSpeedKn) {
        this.minSpeedKn = minSpeedKn;
    }

    private double maxSpeedKn;

    public double getMaxSpeedKn() {
        return maxSpeedKn;
    }

    public void setMaxSpeedKn(double maxSpeedKn) {
        this.maxSpeedKn = maxSpeedKn;
    }

    private double changeYaw;

    public double getChangeYaw() {
        return changeYaw;
    }

    public void setChangeYaw(double changeYaw) {
        this.changeYaw = changeYaw;
    }

    private String missionNotes;

    public String getMissionNotes() {
        return missionNotes;
    }

    public void setMissionNotes(String missionNotes) {
        this.missionNotes = missionNotes;
    }

    private double windDirection;

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    private String turnType;

    public String getTurnType() {
        return turnType;
    }

    public void setTurnType(String turnType) {
        this.turnType = turnType;
    }

    private boolean segmentEnd;

    public boolean isSegmentEnd() {
        return segmentEnd;
    }

    public void setSegmentEnd(boolean segmentEnd) {
        this.segmentEnd = segmentEnd;
    }

    private Map<String,Object> wpProps;

    public Map<String, Object> getWpProps() {
        return wpProps;
    }

    public void setWpProps(Map<String, Object> wpProps) {
        this.wpProps = wpProps;
    }

    public WayPoints(double minAltitudeFt, double maxAltitudeFt,
                     WayPointLocation wpLocation, Date effectiveTimeBegin, Date effectiveTimeEnd,
                     double minSpeedKn, double maxSpeedKn, double changeYaw, String missionNotes,
                     double windDirection, String turnType, boolean segmentEnd, Map<String, Object> wpProps)
    {
        this.minAltitudeFt = minAltitudeFt;
        this.maxAltitudeFt = maxAltitudeFt;
        this.wpLocation = wpLocation;
        this.effectiveTimeBegin = effectiveTimeBegin;
        this.effectiveTimeEnd = effectiveTimeEnd;
        this.minSpeedKn = minSpeedKn;
        this.maxSpeedKn = maxSpeedKn;
        this.changeYaw = changeYaw;
        this.missionNotes = missionNotes;
        this.windDirection = windDirection;
        this.turnType = turnType;
        this.segmentEnd = segmentEnd;
        this.wpProps = wpProps;
    }
}
