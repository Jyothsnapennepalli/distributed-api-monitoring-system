package com.jyosh.monitoringsystem.service;

import com.jyosh.monitoringsystem.entity.Monitor;
import com.jyosh.monitoringsystem.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    public Monitor createMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public Monitor updateMonitor(Long id, Monitor updatedMonitor) {

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

    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }
}