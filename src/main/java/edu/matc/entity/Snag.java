package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "snag")
public class Snag {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "log_id")
    private int snagId;

    @Column(name = "log_id")
    private int logId;

    @Column(name = "location")
    private String locationOfSnag;

    @Column(name = "type")
    private String typeOfSnag;

    @Column(name = "blockage_amount")
    private String blockageAmount;

    @Column(name = "estimated_delay")
    private int estimatedDelay;

    public Snag() {    }

    public Snag(int snagId, int logId, String locationOfSnag, String typeOfSnag, String blockage_amount, int estimatedDelay) {
        this.snagId = snagId;
        this.logId = logId;
        this.locationOfSnag = locationOfSnag;
        this.typeOfSnag = typeOfSnag;
        this.blockageAmount = blockage_amount;
        this.estimatedDelay = estimatedDelay;
    }

    public int getSnagId() {
        return snagId;
    }

    public void setSnagId(int snagId) {
        this.snagId = snagId;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLocationOfSnag() {
        return locationOfSnag;
    }

    public void setLocationOfSnag(String locationOfSnag) {
        this.locationOfSnag = locationOfSnag;
    }

    public String getTypeOfSnag() {
        return typeOfSnag;
    }

    public void setTypeOfSnag(String typeOfSnag) {
        this.typeOfSnag = typeOfSnag;
    }

    public String getBlockage_amount() {
        return blockageAmount;
    }

    public void setBlockage_amount(String blockage_amount) {
        this.blockageAmount = blockage_amount;
    }

    public int getEstimatedDelay() {
        return estimatedDelay;
    }

    public void setEstimatedDelay(int estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    @Override
    public String toString() {
        return "snag{" +
                "snagId=" + snagId +
                ", logId=" + logId +
                ", locationOfSnag='" + locationOfSnag + '\'' +
                ", typeOfSnag='" + typeOfSnag + '\'' +
                ", blockage_amount='" + blockageAmount + '\'' +
                ", estimatedDelay=" + estimatedDelay +
                '}';
    }
}

