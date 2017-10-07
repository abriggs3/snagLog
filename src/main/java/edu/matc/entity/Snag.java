package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Snag")
public class Snag implements Storable {
    private int snagId;
    private String location;
    private String type;
    private String blockageAmount;
    private Integer estimatedDelay;
    private Log logByLogId;

    public Snag() {
    }

    public Snag(int snagId, String location, String type, String blockageAmount, Integer estimatedDelay, Log logByLogId) {
        this.snagId = snagId;
        this.location = location;
        this.type = type;
        this.blockageAmount = blockageAmount;
        this.estimatedDelay = estimatedDelay;
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
    @Column(name = "location", nullable = true, length = 30)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "blockage_amount", nullable = true, length = 20)
    public String getBlockageAmount() {
        return blockageAmount;
    }

    public void setBlockageAmount(String blockageAmount) {
        this.blockageAmount = blockageAmount;
    }

    @Basic
    @Column(name = "estimated_delay", nullable = true)
    public Integer getEstimatedDelay() {
        return estimatedDelay;
    }

    public void setEstimatedDelay(Integer estimatedDelay) {
        this.estimatedDelay = estimatedDelay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snag snag = (Snag) o;

        if (snagId != snag.snagId) return false;
        if (location != null ? !location.equals(snag.location) : snag.location != null) return false;
        if (type != null ? !type.equals(snag.type) : snag.type != null) return false;
        if (blockageAmount != null ? !blockageAmount.equals(snag.blockageAmount) : snag.blockageAmount != null)
            return false;
        if (estimatedDelay != null ? !estimatedDelay.equals(snag.estimatedDelay) : snag.estimatedDelay != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = snagId;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (blockageAmount != null ? blockageAmount.hashCode() : 0);
        result = 31 * result + (estimatedDelay != null ? estimatedDelay.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "log_id", referencedColumnName = "log_id", nullable = false)
    public Log getLogByLogId() {
        return logByLogId;
    }

    public void setLogByLogId(Log logByLogId) {
        this.logByLogId = logByLogId;
    }

    @Override
    public String toString() {
        return "Snag{" +
                "snagId=" + snagId +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", blockageAmount='" + blockageAmount + '\'' +
                ", estimatedDelay=" + estimatedDelay +
                ", logByLogId=" + logByLogId +
                '}';
    }
}
