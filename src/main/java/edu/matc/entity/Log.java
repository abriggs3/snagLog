package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "log_id")
    private int logId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "river_name")
    private String riverName;

    @Column(name = "state")
    private String state;

    @Column(name = "county")
    private String county;

    @Column(name = "nearest_city")
    private String nearestCity;

    @Column(name = "put_in_location")
    private String putInLocation;

    @Column(name = "takeout_location")
    private String takeOutLocation;

    public Log() {    }

    public Log(int logId, String userName, String riverName, String state, String county, String nearestCity, String putInLocation, String takeOutLocation) {
        this.logId = logId;
        this.userName = userName;
        this.riverName = riverName;
        this.state = state;
        this.county = county;
        this.nearestCity = nearestCity;
        this.putInLocation = putInLocation;
        this.takeOutLocation = takeOutLocation;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getTakeOutLocation() {
        return takeOutLocation;
    }

    public void setTakeOutLocation(String takeOutLocation) {
        this.takeOutLocation = takeOutLocation;
    }

    @Override
    public String toString() {
        return "log{" +
                "logId=" + logId +
                ", userName='" + userName + '\'' +
                ", riverName='" + riverName + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", nearestCity='" + nearestCity + '\'' +
                ", putInLocation='" + putInLocation + '\'' +
                ", takeOutLocation='" + takeOutLocation + '\'' +
                '}';
    }
}
