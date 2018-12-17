package com.alten.repository;

import com.alten.model.VehicleStatusLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatusLogRepository extends JpaRepository<VehicleStatusLog, Long> {
}
