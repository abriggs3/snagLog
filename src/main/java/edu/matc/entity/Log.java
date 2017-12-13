package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Log.
 */
@Entity
@Table(name = "Log")
public class Log implements Storable {

    @Id
    @Column(name = "log_id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int logId;

    @Basic
    @Column(name = "launchDate")
    private Date launchDate;

    @Basic
    @Column(name = "tripDuration")
    private int tripDuration;

    @Basic
    @Column(name = "startLocationLat")
    private Double startLocationLat;

    @Basic
    @Column(name = "startLocationLon")
    private Double startLocationLon;

    @Basic
    @Column(name = "endLocationLat")
    private Double endLocationLat;

    @Basic
    @Column(name = "endLocationLon")
    private Double endLocationLon;

    @Basic
    @Column(name = "waterBodyName")
    private String waterBodyName;

    @Basic
    @Column(name = "waterBodyType")
    private String waterBodyType;

    @Basic
    @Column(name = "waterSubChoice")
    private String waterSubChoice;

    @Basic
    @Column(name = "logText")
    private String logText;

    @Basic
    @Column(name = "city")
    private String city;

    @Basic
    @Column(name = "state")
    private String state;

    @Basic
    @Column(name = "weatherDescription")
    private String weatherDescription;

    @Basic
    @Column(name = "temperature")
    private Double temperature;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    private User userByUserId;

    /**
     * Instantiates a new Log.
     */
// required empty constructor
    public Log() {
    }

    /**
     * Instantiates a new Log.
     *
     * @param launchDate         the launch date
     * @param tripDuration       the trip duration
     * @param startLocationLat   the start location lat
     * @param startLocationLon   the start location lon
     * @param endLocationLat     the end location lat
     * @param endLocationLon     the end location lon
     * @param waterBodyName      the water body name
     * @param waterBodyType      the water body type
     * @param waterSubChoice     the water sub choice
     * @param logText            the log text
     * @param city               the city
     * @param state              the state
     * @param weatherDescription the weather description
     * @param temperature        the temperature
     * @param userByUserId       the user by user id
     */
// partial constructor
    public Log(Date launchDate, int tripDuration, Double startLocationLat, Double startLocationLon, Double endLocationLat, Double endLocationLon, String waterBodyName, String waterBodyType, String waterSubChoice, String logText, String city, String state, String weatherDescription, Double temperature, User userByUserId) {
        this.launchDate = launchDate;
        this.tripDuration = tripDuration;
        this.startLocationLat = startLocationLat;
        this.startLocationLon = startLocationLon;
        this.endLocationLat = endLocationLat;
        this.endLocationLon = endLocationLon;
        this.waterBodyName = waterBodyName;
        this.waterBodyType = waterBodyType;
        this.waterSubChoice = waterSubChoice;
        this.logText = logText;
        this.city = city;
        this.state = state;
        this.weatherDescription = weatherDescription;
        this.temperature = temperature;
        this.userByUserId = userByUserId;
    }

    /**
     * Gets log id.
     *
     * @return the log id
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Sets log id.
     *
     * @param logId the log id
     */
    public void setLogId(int logId) {
        this.logId = logId;
    }

    /**
     * Gets launch date.
     *
     * @return the launch date
     */
    public Date getLaunchDate() {
        return launchDate;
    }

    /**
     * Sets launch date.
     *
     * @param launchDate the launch date
     */
    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    /**
     * Gets trip duration.
     *
     * @return the trip duration
     */
    public int getTripDuration() {
        return tripDuration;
    }

    /**
     * Sets trip duration.
     *
     * @param tripDuration the trip duration
     */
    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    /**
     * Gets start location lat.
     *
     * @return the start location lat
     */
    public Double getStartLocationLat() {
        return startLocationLat;
    }

    /**
     * Sets start location lat.
     *
     * @param startLocationLat the start location lat
     */
    public void setStartLocationLat(Double startLocationLat) {
        this.startLocationLat = startLocationLat;
    }

    /**
     * Gets start location lon.
     *
     * @return the start location lon
     */
    public Double getStartLocationLon() {
        return startLocationLon;
    }

    /**
     * Sets start location lon.
     *
     * @param startLocationLon the start location lon
     */
    public void setStartLocationLon(Double startLocationLon) {
        this.startLocationLon = startLocationLon;
    }

    /**
     * Gets end location lat.
     *
     * @return the end location lat
     */
    public Double getEndLocationLat() {
        return endLocationLat;
    }

    /**
     * Sets end location lat.
     *
     * @param endLocationLat the end location lat
     */
    public void setEndLocationLat(Double endLocationLat) {
        this.endLocationLat = endLocationLat;
    }

    /**
     * Gets end location lon.
     *
     * @return the end location lon
     */
    public Double getEndLocationLon() {
        return endLocationLon;
    }

    /**
     * Sets end location lon.
     *
     * @param endLocationLon the end location lon
     */
    public void setEndLocationLon(Double endLocationLon) {
        this.endLocationLon = endLocationLon;
    }

    /**
     * Gets water body name.
     *
     * @return the water body name
     */
    public String getWaterBodyName() {
        return waterBodyName;
    }

    /**
     * Sets water body name.
     *
     * @param waterBodyName the water body name
     */
    public void setWaterBodyName(String waterBodyName) {
        this.waterBodyName = waterBodyName;
    }

    /**
     * Gets water body type.
     *
     * @return the water body type
     */
    public String getWaterBodyType() {
        return waterBodyType;
    }

    /**
     * Sets water body type.
     *
     * @param waterBodyType the water body type
     */
    public void setWaterBodyType(String waterBodyType) {
        this.waterBodyType = waterBodyType;
    }

    /**
     * Gets water sub choice.
     *
     * @return the water sub choice
     */
    public String getWaterSubChoice() {
        return waterSubChoice;
    }

    /**
     * Sets water sub choice.
     *
     * @param waterSubChoice the water sub choice
     */
    public void setWaterSubChoice(String waterSubChoice) {
        this.waterSubChoice = waterSubChoice;
    }

    /**
     * Gets log text.
     *
     * @return the log text
     */
    public String getLogText() {
        return logText;
    }

    /**
     * Sets log text.
     *
     * @param logText the log text
     */
    public void setLogText(String logText) {
        this.logText = logText;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets weather description.
     *
     * @return the weather description
     */
    public String getWeatherDescription() {
        return weatherDescription;
    }

    /**
     * Sets weather description.
     *
     * @param weatherDescription the weather description
     */
    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Sets temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets user by user id.
     *
     * @return the user by user id
     */
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
        if (!(o instanceof Log)) return false;

        Log log = (Log) o;

        if (getLogId() != log.getLogId()) return false;
        if (getTripDuration() != log.getTripDuration()) return false;
        if (getLaunchDate() != null ? !getLaunchDate().equals(log.getLaunchDate()) : log.getLaunchDate() != null)
            return false;
        if (getStartLocationLat() != null ? !getStartLocationLat().equals(log.getStartLocationLat()) : log.getStartLocationLat() != null)
            return false;
        if (getStartLocationLon() != null ? !getStartLocationLon().equals(log.getStartLocationLon()) : log.getStartLocationLon() != null)
            return false;
        if (getEndLocationLat() != null ? !getEndLocationLat().equals(log.getEndLocationLat()) : log.getEndLocationLat() != null)
            return false;
        if (getEndLocationLon() != null ? !getEndLocationLon().equals(log.getEndLocationLon()) : log.getEndLocationLon() != null)
            return false;
        if (getWaterBodyName() != null ? !getWaterBodyName().equals(log.getWaterBodyName()) : log.getWaterBodyName() != null)
            return false;
        if (getWaterBodyType() != null ? !getWaterBodyType().equals(log.getWaterBodyType()) : log.getWaterBodyType() != null)
            return false;
        if (getWaterSubChoice() != null ? !getWaterSubChoice().equals(log.getWaterSubChoice()) : log.getWaterSubChoice() != null)
            return false;
        if (getLogText() != null ? !getLogText().equals(log.getLogText()) : log.getLogText() != null) return false;
        if (getCity() != null ? !getCity().equals(log.getCity()) : log.getCity() != null) return false;
        if (getState() != null ? !getState().equals(log.getState()) : log.getState() != null) return false;
        if (getWeatherDescription() != null ? !getWeatherDescription().equals(log.getWeatherDescription()) : log.getWeatherDescription() != null)
            return false;
        if (getTemperature() != null ? !getTemperature().equals(log.getTemperature()) : log.getTemperature() != null)
            return false;
        return getUserByUserId() != null ? getUserByUserId().equals(log.getUserByUserId()) : log.getUserByUserId() == null;
    }

    @Override
    public int hashCode() {
        int result = getLogId();
        result = 31 * result + (getLaunchDate() != null ? getLaunchDate().hashCode() : 0);
        result = 31 * result + getTripDuration();
        result = 31 * result + (getStartLocationLat() != null ? getStartLocationLat().hashCode() : 0);
        result = 31 * result + (getStartLocationLon() != null ? getStartLocationLon().hashCode() : 0);
        result = 31 * result + (getEndLocationLat() != null ? getEndLocationLat().hashCode() : 0);
        result = 31 * result + (getEndLocationLon() != null ? getEndLocationLon().hashCode() : 0);
        result = 31 * result + (getWaterBodyName() != null ? getWaterBodyName().hashCode() : 0);
        result = 31 * result + (getWaterBodyType() != null ? getWaterBodyType().hashCode() : 0);
        result = 31 * result + (getWaterSubChoice() != null ? getWaterSubChoice().hashCode() : 0);
        result = 31 * result + (getLogText() != null ? getLogText().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getWeatherDescription() != null ? getWeatherDescription().hashCode() : 0);
        result = 31 * result + (getTemperature() != null ? getTemperature().hashCode() : 0);
        result = 31 * result + (getUserByUserId() != null ? getUserByUserId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", launchDate=" + launchDate +
                ", tripDuration=" + tripDuration +
                ", startLocationLat=" + startLocationLat +
                ", startLocationLon=" + startLocationLon +
                ", endLocationLat=" + endLocationLat +
                ", endLocationLon=" + endLocationLon +
                ", waterBodyName='" + waterBodyName + '\'' +
                ", waterBodyType='" + waterBodyType + '\'' +
                ", waterSubChoice='" + waterSubChoice + '\'' +
                ", logText='" + logText + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", temperature=" + temperature +
                ", userByUserId=" + userByUserId +
                '}';
    }
}
