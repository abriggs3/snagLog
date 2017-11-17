package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Snag")
public class Snag implements Storable {
    private int snagId;
    private double locationLat;
    private double locationLon;
    private String blockageType;
    private String hazard;
    private Integer estimatedDelay;
    private String additionalInformation;
    private User userByUserId;
    private LocalDate dateMarked;
    private boolean cleared;

    public Snag() {
    }

    public Snag(int snagId, double locationLat, double locationLon, String blockageType, String hazard, Integer estimatedDelay, String additionalInformation, User userByUserId, LocalDate dateMarked, boolean cleared) {
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
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getSnagId() {
        return snagId;
    }

    public void setSnagId(int snagId) {
        this.snagId = snagId;
    }

    @Basic
    @Column(name = "locationLat", nullable = true, length = 30)
    public double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(double locationLat) {
        this.locationLat = locationLat;
    }

    @Basic
    @Column(name = "locationLon", nullable = true, length = 30)
    public double getLocationLon() {
        return locationLon;
    }

    public void setLocationLon(double locationLon) {
        this.locationLon = locationLon;
    }

    @Basic
    @Column(name = "blockage_type", nullable = true, length = 30)
    public String getBlockageType() {
        return blockageType;
    }

    public void setBlockageType(String blockageType) {
        this.blockageType = blockageType;
    }


    @Basic
    @Column(name = "hazard", nullable = true, length = 20)
    public String getHazard() {
        return hazard;
    }

    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

    @Basic
    @Column(name = "estimated_delay", nullable = true)
    public Integer getEstimatedDelay() {
        return estimatedDelay;
    }

    public void setEstimatedDelay(Integer estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public LocalDate getDateMarked() {
        return dateMarked;
    }

    public void setDateMarked(LocalDate dateMarked) {
        this.dateMarked = dateMarked;
    }

    @Basic
    @Column(name = "cleared", nullable = true)
    public boolean isCleared() {
        return cleared;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    @Basic
    @Column(name = "additional_desc", nullable = true)
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
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
