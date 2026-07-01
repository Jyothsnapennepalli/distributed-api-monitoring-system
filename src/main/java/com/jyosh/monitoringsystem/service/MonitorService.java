package com.jyosh.monitoringsystem.service;

import com.jyosh.monitoringsystem.dto.MonitorDto;
import com.jyosh.monitoringsystem.entity.Monitor;
import com.jyosh.monitoringsystem.exception.MonitorNotFoundException;
import com.jyosh.monitoringsystem.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<MonitorDto> getAllMonitors() {
        return monitorRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public Monitor createMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public Monitor updateMonitor(Long id, Monitor updatedMonitor) {

        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new MonitorNotFoundException(id));

        monitor.setName(updatedMonitor.getName());
        monitor.setUrl(updatedMonitor.getUrl());
        monitor.setStatus(updatedMonitor.getStatus());

        return monitorRepository.save(monitor);
    }

    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id)
                .orElseThrow(() -> new MonitorNotFoundException(id));
    }

    public void deleteMonitor(Long id) {

        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new MonitorNotFoundException(id));

        monitorRepository.delete(monitor);
    }

    private MonitorDto convertToDto(Monitor monitor) {
        return new MonitorDto(
                monitor.getId(),
                monitor.getName(),
                monitor.getStatus(),
                monitor.getResponseTime(),
                monitor.getLastChecked()
        );
    }
}