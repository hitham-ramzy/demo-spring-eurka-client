package com.alten.service;


import com.alten.constant.TestConstants;
import com.alten.model.Vehicle;
import com.alten.model.VehicleCriteria;
import com.alten.repository.VehicleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Test class for the Vehicle Service layer.
 *
 * @see com.alten.service.VehicleService
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleServiceTest {

    @InjectMocks
    private VehicleService vehicleService;

    @Mock
    private VehicleRepository vehicleRepository;


    //    Test Selecting an existed vehicle - should pass
    @Test
    public void findVehicle() {
        when(vehicleRepository.findById(anyString())).thenReturn(Optional.of(new Vehicle()));
        Optional<Vehicle> vehicleOptional = vehicleService.findOne(TestConstants.VEHICLE_ID_FOUND);
        Assert.assertTrue(vehicleOptional.isPresent());
    }

    //    Test Selecting a NOT existed vehicle - should not found the vehicle
    @Test
    public void testNotFoundVehicle() {
        Assert.assertFalse(vehicleService.findOne(TestConstants.VEHICLE_ID_NOT_FOUND).isPresent());
    }

    //    Test creating vehicle
    @Test
    public void createVehicle() {
        Vehicle vehicle = TestConstants.createVehicleObject();
        when(vehicleRepository.save(vehicle)).thenReturn(new Vehicle());
        Assert.assertNotNull(vehicleService.save(vehicle));
    }

    //    Test list Vehicles
    @Test
    public void listVehicle() {
        vehicleService.findAll(new VehicleCriteria(), Pageable.unpaged());
    }

    //    Test delete Vehicles
    @Test
    public void deleteVehicle() {
        when(vehicleRepository.findById(TestConstants.VEHICLE_ID_FOUND)).thenReturn(Optional.of(new Vehicle()));
        vehicleService.delete(TestConstants.VEHICLE_ID_FOUND);
    }
}
