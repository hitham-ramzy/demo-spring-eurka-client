package com.alten.service;

import com.alten.model.Vehicle;
import com.alten.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VehicleService {

    private final Logger log = LoggerFactory.getLogger(VehicleService.class);

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    /**
     * Save a vehicle.
     *
     * @param vehicle the entity to save
     * @return the persisted entity
     */
    public Vehicle save(Vehicle vehicle) {
        log.debug("Request to save Vehicle : {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

    /**
     * Get all the vehicles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Vehicle> findAll(Pageable pageable) {
        log.debug("Request to get all Drivers");
        return vehicleRepository.findAll(pageable);
    }

    /**
     * Get one vehicle by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Vehicle> findOne(Long id) {
        log.debug("Request to get Vehicle : {}", id);
        return vehicleRepository.findById(id);
    }

    /**
     * Delete the vehicle by id.
     *
     * @param id the id of the entity
     */
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete Vehicle : {}", id);
        Optional<Vehicle> vehicleOptional = findOne(id);
        vehicleOptional.ifPresent(vehicleRepository::delete);
    }

    @Transactional
    public void deleteByCustomerId(Long customerId) {
         vehicleRepository.deleteByCustomerId(customerId);
    }
}
