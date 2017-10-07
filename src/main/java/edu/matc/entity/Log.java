package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Log")
public class Log implements Storable {

    @Id
    @Column(name = "log_id", nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int logId;

    @Basic
    @Column(name = "river_name", nullable = false)
    private String riverName;

    @Basic
    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Basic
    @Column(name = "county", nullable = true, length = 30)
    private String county;

    @Basic
    @Column(name = "nearest_city", nullable = true, length = 30)
    private String nearestCity;

    @Basic
    @Column(name = "put_in_location", nullable = true, length = 256)
    private String putInLocation;

    @Basic
    @Column(name = "takeout_location", nullable = true, length = 256)
    private String takeoutLocation;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)
    private User userByUserId;

    // required empty constructor
    public Log() {
    }

    // partial constructor
    public Log(String riverName, String state, String county, String nearestCity, String putInLocation, String takeoutLocation, User userByUserId) {
        this.riverName = riverName;
        this.state = state;
        this.county = county;
        this.nearestCity = nearestCity;
        this.putInLocation = putInLocation;
        this.takeoutLocation = takeoutLocation;
    }

    public int getLogId() {
        return logId;
    }
    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getNearestCity() {
        return nearestCity;
    }

    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    public String getPutInLocation() {
        return putInLocation;
    }

    public void setPutInLocation(String putInLocation) {
        this.putInLocation = putInLocation;
    }

    public String getTakeoutLocation() {
        return takeoutLocation;
    }

    public void setTakeoutLocation(String takeoutLocation) {
        this.takeoutLocation = takeoutLocation;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (logId != log.logId) return false;
        if (riverName != null ? !riverName.equals(log.riverName) : log.riverName != null) return false;
        if (state != null ? !state.equals(log.state) : log.state != null) return false;
        if (county != null ? !county.equals(log.county) : log.county != null) return false;
        if (nearestCity != null ? !nearestCity.equals(log.nearestCity) : log.nearestCity != null) return false;
        if (putInLocation != null ? !putInLocation.equals(log.putInLocation) : log.putInLocation != null) return false;
        if (takeoutLocation != null ? !takeoutLocation.equals(log.takeoutLocation) : log.takeoutLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (riverName != null ? riverName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (nearestCity != null ? nearestCity.hashCode() : 0);
        result = 31 * result + (putInLocation != null ? putInLocation.hashCode() : 0);
        result = 31 * result + (takeoutLocation != null ? takeoutLocation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", riverName='" + riverName + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", nearestCity='" + nearestCity + '\'' +
                ", putInLocation='" + putInLocation + '\'' +
                ", takeoutLocation='" + takeoutLocation + '\'' +
                '}';
    }
}
