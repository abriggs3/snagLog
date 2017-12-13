package edu.matc.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * The type Snag.
 */
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

    /**
     * Instantiates a new Snag.
     */
    public Snag() {
    }

    /**
     * Instantiates a new Snag.
     *
     * @param snagId                the snag id
     * @param locationLat           the location lat
     * @param locationLon           the location lon
     * @param blockageType          the blockage type
     * @param hazard                the hazard
     * @param estimatedDelay        the estimated delay
     * @param additionalInformation the additional information
     * @param userByUserId          the user by user id
     * @param dateMarked            the date marked
     * @param cleared               the cleared
     */
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

    /**
     * Instantiates a new Snag.
     *
     * @param locationLat           the location lat
     * @param locationLon           the location lon
     * @param blockageType          the blockage type
     * @param hazard                the hazard
     * @param estimatedDelay        the estimated delay
     * @param additionalInformation the additional information
     * @param userByUserId          the user by user id
     */
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


    /**
     * Gets snag id.
     *
     * @return the snag id
     */
    @Id
    @Column(name = "snag_id", nullable = false)
    public int getSnagId() {
        return snagId;
    }

    /**
     * Sets snag id.
     *
     * @param snagId the snag id
     */
    public void setSnagId(int snagId) {
        this.snagId = snagId;
    }

    /**
     * Gets location lat.
     *
     * @return the location lat
     */
    @Basic
    @Column(name = "locationLat", nullable = false, precision = 8)
    public double getLocationLat() {
        return locationLat;
    }

    /**
     * Sets location lat.
     *
     * @param locationLat the location lat
     */
    public void setLocationLat(double locationLat) {
        this.locationLat = locationLat;
    }

    /**
     * Gets location lon.
     *
     * @return the location lon
     */
    @Basic
    @Column(name = "locationLon", nullable = false, precision = 8)
    public double getLocationLon() {
        return locationLon;
    }

    /**
     * Sets location lon.
     *
     * @param locationLon the location lon
     */
    public void setLocationLon(double locationLon) {
        this.locationLon = locationLon;
    }

    /**
     * Gets blockage type.
     *
     * @return the blockage type
     */
    @Basic
    @Column(name = "blockage_type", nullable = false, length = 30)
    public String getBlockageType() {
        return blockageType;
    }

    /**
     * Sets blockage type.
     *
     * @param blockageType the blockage type
     */
    public void setBlockageType(String blockageType) {
        this.blockageType = blockageType;
    }

    /**
     * Gets hazard.
     *
     * @return the hazard
     */
    @Basic
    @Column(name = "hazard", nullable = false, length = 20)
    public String getHazard() {
        return hazard;
    }

    /**
     * Sets hazard.
     *
     * @param hazard the hazard
     */
    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

    /**
     * Gets estimated delay.
     *
     * @return the estimated delay
     */
    @Basic
    @Column(name = "estimated_delay", nullable = false)
    public Integer getEstimatedDelay() {
        return estimatedDelay;
    }

    /**
     * Sets estimated delay.
     *
     * @param estimatedDelay the estimated delay
     */
    public void setEstimatedDelay(Integer estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    /**
     * Gets additional information.
     *
     * @return the additional information
     */
    @Basic
    @Column(name = "additional_desc", nullable = false, length = -1)
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets additional information.
     *
     * @param additionalDesc the additional desc
     */
    public void setAdditionalInformation(String additionalDesc) {
        this.additionalInformation = additionalDesc;
    }

    /**
     * Gets date marked.
     *
     * @return the date marked
     */
    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDateMarked() {
        return dateMarked;
    }

    /**
     * Sets date marked.
     *
     * @param date the date
     */
    public void setDateMarked(Timestamp date) {
        this.dateMarked = date;
    }

    /**
     * Gets cleared.
     *
     * @return the cleared
     */
    @Basic
    @Column(name = "cleared", nullable = false)
    public boolean getCleared() {
        return cleared;
    }

    /**
     * Sets cleared.
     *
     * @param cleared the cleared
     */
    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    /**
     * Gets user by user id.
     *
     * @return the user by user id
     */
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    /**
     * Sets user by user id.
     *
     * @param userByUserId the user by user id
     */
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
