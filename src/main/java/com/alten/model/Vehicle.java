package com.alten.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid")
    private String id;

    @Column(name = "reg")
    private String RegistrationNumber;

    @ManyToOne
    private Customer customer;

    @Column(name = "ip")
    private String ip;

    @Column(name = "connected")
    private Boolean connected;

    @Column(name = "last_status_time")
    private ZonedDateTime lastStatusTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public ZonedDateTime getLastStatusTime() {
        return lastStatusTime;
    }

    public void setLastStatusTime(ZonedDateTime lastStatusTime) {
        this.lastStatusTime = lastStatusTime;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", RegistrationNumber='" + RegistrationNumber + '\'' +
                ", customer=" + customer +
                ", ip='" + ip + '\'' +
                ", connected=" + connected +
                ", lastStatusTime=" + lastStatusTime +
                '}';
    }
}
