package com.jyosh.monitoringsystem.repository;

import com.jyosh.monitoringsystem.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}