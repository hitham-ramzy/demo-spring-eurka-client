package com.alten.service;


import com.alten.constant.TestConstants;
import com.alten.model.Customer;
import com.alten.repository.CustomerRepository;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Test class for the Customer Service layer.
 *
 * @see CustomerService
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private VehicleService vehicleService;

    @Mock
    private VehicleRepository vehicleRepository;


    //    Test Selecting an existed customer - should pass
    @Test
    public void findCustomer() {
        when(customerRepository.findById(TestConstants.CUSTOMER_ID_FOUND)).thenReturn(Optional.of(new Customer()));
        Optional<Customer> customerOptional = customerService.findOne(TestConstants.CUSTOMER_ID_FOUND);
        Assert.assertTrue(customerOptional.isPresent());
    }

    //    Test Selecting a NOT existed customer - should not found the customer
    @Test
    public void testNotFoundCustomer() {
        Assert.assertFalse(customerService.findOne(TestConstants.Customer_ID_NOT_FOUND).isPresent());
    }

    //    Test creating customer
    @Test
    public void createCustomer() {
        Customer customer = TestConstants.createCustomerObject();
        when(customerRepository.save(customer)).thenReturn(new Customer());
        Assert.assertNotNull(customerService.save(customer));
    }

    //    Test list Customers
    @Test
    public void listCustomer() {
        customerService.findAll(Pageable.unpaged());
    }

    //    Test delete Customers
    @Test
    public void deleteCustomer() {
        when(customerRepository.findById(TestConstants.CUSTOMER_ID_FOUND)).thenReturn(Optional.of(new Customer()));
        doNothing().when(vehicleRepository).deleteByCustomerId(anyLong());
        customerService.delete(TestConstants.CUSTOMER_ID_FOUND);
    }
}
