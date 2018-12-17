package com.alten.service;

import com.alten.model.VehicleStatusLog;
import com.alten.repository.VehicleStatusLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VehicleStatusLogService {

    private final Logger log = LoggerFactory.getLogger(VehicleStatusLogService.class);

    private final VehicleStatusLogRepository vehicleStatusLogRepository;

    public VehicleStatusLogService(VehicleStatusLogRepository vehicleStatusLogRepository) {
        this.vehicleStatusLogRepository = vehicleStatusLogRepository;
    }


    /**
     * Save a vehicleStatusLog.
     *
     * @param vehicleStatusLog the entity to save
     * @return the persisted entity
     */
    public VehicleStatusLog save(VehicleStatusLog vehicleStatusLog) {
        log.debug("Request to save VehicleStatusLog : {}", vehicleStatusLog);
        return vehicleStatusLogRepository.save(vehicleStatusLog);
    }

    /**
     * Get all the vehicleStatusLogs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<VehicleStatusLog> findAll(Pageable pageable) {
        log.debug("Request to get all Drivers");
        return vehicleStatusLogRepository.findAll(pageable);
    }

    /**
     * Get one vehicleStatusLog by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<VehicleStatusLog> findOne(Long id) {
        log.debug("Request to get VehicleStatusLog : {}", id);
        return vehicleStatusLogRepository.findById(id);
    }

    /**
     * Delete the vehicleStatusLog by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete VehicleStatusLog : {}", id);
        Optional<VehicleStatusLog> vehicleStatusLogOptional = findOne(id);
        vehicleStatusLogOptional.ifPresent(vehicleStatusLogRepository::delete);
    }
}
