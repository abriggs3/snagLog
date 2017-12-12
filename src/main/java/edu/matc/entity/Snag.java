package edu.matc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Snag {
    private int snagId;
    private double locationLat;
    private double locationLon;
    private String blockageType;
    private String hazard;
    private Integer estimatedDelay;
    private String additionalInformation;
    private Timestamp dateMarked;
    private boolean cleared;
    private User userByUserId;

    public Snag() {
    }

    public Snag(int snagId, double locationLat, double locationLon, String blockageType, String hazard, Integer estimatedDelay, String additionalInformation, User userByUserId, Timestamp dateMarked, boolean cleared) {
        this.snagId = snagId;
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.blockageType = blockageType;
        this.hazard = hazard;
        this.estimatedDelay = estimatedDelay;
        this.additionalInformation = additionalInformation;
        this.userByUserId = userByUserId;
        this.dateMarked = dateMarked;
        this.cleared = cleared;
    }

    // partial constructor for use with inserts of Snags into db
    public Snag(double locationLat, double locationLon, String blockageType, String hazard, Integer estimatedDelay, String additionalInformation, User userByUserId) {
        this.locationLat = locationLat;
        this.locationLon = locationLon;
        this.blockageType = blockageType;
        this.hazard = hazard;
        this.estimatedDelay = estimatedDelay;
        this.additionalInformation = additionalInformation;
        this.userByUserId = userByUserId;
    }


    @Id
    @Column(name = "snag_id", nullable = false)
    public int getSnagId() {
        return snagId;
    }

    public void setSnagId(int snagId) {
        this.snagId = snagId;
    }

    @Basic
    @Column(name = "locationLat", nullable = false, precision = 8)
    public double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(double locationLat) {
        this.locationLat = locationLat;
    }

    @Basic
    @Column(name = "locationLon", nullable = false, precision = 8)
    public double getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(double locationLon) {
        this.locationLon = locationLon;
    }

    @Basic
    @Column(name = "blockage_type", nullable = false, length = 30)
    public String getBlockageType() {
        return blockageType;
    }

    public void setBlockageType(String blockageType) {
        this.blockageType = blockageType;
    }

    @Basic
    @Column(name = "hazard", nullable = false, length = 20)
    public String getHazard() {
        return hazard;
    }

    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

    @Basic
    @Column(name = "estimated_delay", nullable = false)
    public Integer getEstimatedDelay() {
        return estimatedDelay;
    }

    public void setEstimatedDelay(Integer estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    @Basic
    @Column(name = "additional_desc", nullable = false, length = -1)
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalDesc) {
        this.additionalInformation = additionalDesc;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDateMarked() {
        return dateMarked;
    }

    public void setDateMarked(Timestamp date) {
        this.dateMarked = date;
    }

    @Basic
    @Column(name = "cleared", nullable = false)
    public boolean getCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snag)) return false;

        Snag snag = (Snag) o;

        if (getSnagId() != snag.getSnagId()) return false;
        if (Double.compare(snag.getLocationLat(), getLocationLat()) != 0) return false;
        if (Double.compare(snag.getLocationLon(), getLocationLon()) != 0) return false;
        if (getCleared() != snag.getCleared()) return false;
        if (!getBlockageType().equals(snag.getBlockageType())) return false;
        if (!getHazard().equals(snag.getHazard())) return false;
        if (!getEstimatedDelay().equals(snag.getEstimatedDelay())) return false;
        if (!getAdditionalInformation().equals(snag.getAdditionalInformation())) return false;
        if (!getDateMarked().equals(snag.getDateMarked())) return false;
        return getUserByUserId().equals(snag.getUserByUserId());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = snagId;
        temp = Double.doubleToLongBits(locationLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(locationLon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + blockageType.hashCode();
        result = 31 * result + hazard.hashCode();
        result = 31 * result + estimatedDelay.hashCode();
        result = 31 * result + userByUserId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Snag{" +
                "snagId=" + snagId +
                ", locationLat=" + locationLat +
                ", locationLon=" + locationLon +
                ", blockageType='" + blockageType + '\'' +
                ", hazard='" + hazard + '\'' +
                ", estimatedDelay=" + estimatedDelay +
                ", userByUserId=" + userByUserId +
                '}';
    }
}
