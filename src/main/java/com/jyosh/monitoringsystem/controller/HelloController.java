package com.jyosh.monitoringsystem.controller;

import com.jyosh.monitoringsystem.entity.Monitor;
import com.jyosh.monitoringsystem.model.StatusResponse;
import com.jyosh.monitoringsystem.service.MonitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final MonitorService monitorService;

    public HelloController(MonitorService monitorService) {
        this.monitorService = monitorService;
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
        return monitorService.getAllMonitors();
    }

    @PostMapping("/api/monitors")
    public Monitor createMonitor(@RequestBody Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @PutMapping("/api/monitors/{id}")
    public Monitor updateMonitor(
            @PathVariable Long id,
            @RequestBody Monitor updatedMonitor) {

        return monitorService.updateMonitor(id, updatedMonitor);
    }

    @DeleteMapping("/api/monitors/{id}")
    public void deleteMonitor(@PathVariable Long id) {
        monitorService.deleteMonitor(id);
    }
}