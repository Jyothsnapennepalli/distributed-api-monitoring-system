package com.jyosh.monitoringsystem.controller;

import com.jyosh.monitoringsystem.entity.Monitor;
import com.jyosh.monitoringsystem.model.StatusResponse;
import com.jyosh.monitoringsystem.repository.MonitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    private final MonitorRepository monitorRepository;

    public HelloController(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @GetMapping("/api/status")
    public StatusResponse getStatus() {
        return new StatusResponse(
                "UP",
                "Distributed API Monitoring System"
        );
    }

    @GetMapping("/api/monitors")
    public List<Monitor> getMonitors() {
        return monitorRepository.findAll();
    }

    @PostMapping("/api/monitors")
    public Monitor createMonitor(@RequestBody Monitor monitor) {
        return monitorRepository.save(monitor);
    }
    @PutMapping("/api/monitors/{id}")
    public Monitor updateMonitor(
            @PathVariable Long id,
            @RequestBody Monitor updatedMonitor) {

        Optional<Monitor> monitorOptional =
                monitorRepository.findById(id);

        if (monitorOptional.isPresent()) {

            Monitor monitor = monitorOptional.get();

            monitor.setName(updatedMonitor.getName());
            monitor.setUrl(updatedMonitor.getUrl());
            monitor.setStatus(updatedMonitor.getStatus());

            return monitorRepository.save(monitor);
        }

        return null;
    }
    @DeleteMapping("/api/monitors/{id}")
    public void deleteMonitor(@PathVariable Long id) {
        monitorRepository.deleteById(id);
    }
}