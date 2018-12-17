package com.alten.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class VehicleStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Vehicle vehicle;

    @Column(name = "connected")
    private Boolean connected;

    @Column(name = "date_time")
    private ZonedDateTime dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "VehicleStatusLog{" +
                "id='" + id + '\'' +
                ", vehicle=" + vehicle +
                ", connected=" + connected +
                ", dateTime=" + dateTime +
                '}';
    }
}
