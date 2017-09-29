package edu.matc.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Log {
    private int logId;
    private String userName;
    private String riverName;
    private String state;
    private String county;
    private String nearestCity;
    private String putInLocation;
    private String takeoutLocation;

    public Log() { }

    public Log(int logId, String userName, String riverName, String state, String county, String nearestCity, String putInLocation, String takeoutLocation) {
        this.logId = logId;
        this.userName = userName;
        this.riverName = riverName;
        this.state = state;
        this.county = county;
        this.nearestCity = nearestCity;
        this.putInLocation = putInLocation;
        this.takeoutLocation = takeoutLocation;
    }

    @Id
    @Column(name = "log_id", nullable = false)
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "river_name", nullable = false, length = 30)
    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 2)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "county", nullable = true, length = 30)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "nearest_city", nullable = true, length = 30)
    public String getNearestCity() {
        return nearestCity;
    }

    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    @Basic
    @Column(name = "put_in_location", nullable = true, length = 256)
    public String getPutInLocation() {
        return putInLocation;
    }

    public void setPutInLocation(String putInLocation) {
        this.putInLocation = putInLocation;
    }

    @Basic
    @Column(name = "takeout_location", nullable = true, length = 256)
    public String getTakeoutLocation() {
        return takeoutLocation;
    }

    public void setTakeoutLocation(String takeoutLocation) {
        this.takeoutLocation = takeoutLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (logId != log.logId) return false;
        if (userName != null ? !userName.equals(log.userName) : log.userName != null) return false;
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
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
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
                ", userName='" + userName + '\'' +
                ", riverName='" + riverName + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", nearestCity='" + nearestCity + '\'' +
                ", putInLocation='" + putInLocation + '\'' +
                ", takeoutLocation='" + takeoutLocation + '\'' +
                '}';
    }
}
