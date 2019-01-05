package com.alten.constant;

import com.alten.model.Customer;
import com.alten.model.Vehicle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestConstants {

    public static final String VEHICLE_ID_FOUND = "VLUR4X20009048066";

    public static final long CUSTOMER_ID_FOUND = 1L;

    public static final String VEHICLE_ID_NOT_FOUND = "THIS ID IS JUST FOR TESTING VEHICLE ID";

    public static final long Customer_ID_NOT_FOUND = 100043L;

    public static Vehicle createVehicleObject(){
        Vehicle vehicle = new Vehicle();
        vehicle.setIp("0.0.0.0");
        vehicle.setConnected(true);
        return vehicle;
    }

    public static List<Vehicle> createVehiclesList(){
        Vehicle vehicle = new Vehicle();
        vehicle.setIp("0.0.0.0");
        vehicle.setConnected(true);
        return Collections.singletonList(vehicle);
    }

    public static Customer createCustomerObject(){
        Customer customer = new Customer();
        customer.setName("TEST_NAME");
        customer.setAddress("TEST_ADDRESS");
        return customer;
    }
}
