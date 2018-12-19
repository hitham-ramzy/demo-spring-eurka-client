package com.alten.model;

public class VehicleCriteria {
    private Long customerId;
    private String customerName;
    private Boolean connected;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    @Override
    public String toString() {
        return "VehicleCriteria{" +
                "customerId='" + customerId + '\'' +
                "customerName='" + customerName + '\'' +
                ", connected=" + connected +
                '}';
    }
}
