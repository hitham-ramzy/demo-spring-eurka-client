package com.alten.resource;

import com.alten.model.VehicleStatusLog;
import com.alten.service.VehicleStatusLogService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleStatusLogResource {

    private final Logger log = LoggerFactory.getLogger(VehicleStatusLogResource.class);

    private final VehicleStatusLogService vehicleStatusLogService;

    @Autowired
    public VehicleStatusLogResource(VehicleStatusLogService vehicleStatusLogService) {
        this.vehicleStatusLogService = vehicleStatusLogService;
    }

    @PostMapping("/vehicle-status-log")
    public ResponseEntity<VehicleStatusLog> createVehicleStatusLog(@Valid @RequestBody VehicleStatusLog vehicleStatusLog) throws URISyntaxException {
        log.debug("REST request to save VehicleStatusLog : {}", vehicleStatusLog);
        if (vehicleStatusLog.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        VehicleStatusLog result = vehicleStatusLogService.save(vehicleStatusLog);
        return ResponseEntity.created(new URI("/api/vehicle-status-log/" + result.getId())).body(result);
    }

    @PutMapping("/vehicle-status-log")
    public ResponseEntity<VehicleStatusLog> updateVehicleStatusLog(@Valid @RequestBody VehicleStatusLog vehicleStatusLog) throws URISyntaxException {
        log.debug("REST request to update VehicleStatusLog : {}", vehicleStatusLog);
        if (vehicleStatusLog.getId() == null) {
            return createVehicleStatusLog(vehicleStatusLog);
        }
        return ResponseEntity.ok(vehicleStatusLogService.save(vehicleStatusLog));
    }

    @GetMapping("/vehicle-status-log")
    public ResponseEntity<List<VehicleStatusLog>> getAllVehicles(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Vehicles");
        Page<VehicleStatusLog> page = vehicleStatusLogService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/vehicle-status-log/{id}")
    public ResponseEntity<VehicleStatusLog> getVehicleStatusLog(@PathVariable Long id) {
        log.debug("REST request to get VehicleStatusLog : {}", id);
        return ResponseEntity.ok(vehicleStatusLogService.findOne(id).orElse(null));
    }

    @DeleteMapping("/vehicle-status-log/{id}")
    public ResponseEntity<Void> deleteVehicleStatusLog(@PathVariable Long id) {
        log.debug("REST request to delete VehicleStatusLog : {}", id);
        vehicleStatusLogService.delete(id);
        return ResponseEntity.ok().build();
    }
}
