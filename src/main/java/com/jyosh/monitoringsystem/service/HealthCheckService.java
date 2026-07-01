package com.jyosh.monitoringsystem.service;

import com.jyosh.monitoringsystem.entity.Monitor;
import com.jyosh.monitoringsystem.repository.MonitorRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HealthCheckService {

    private final MonitorRepository monitorRepository;

    public HealthCheckService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void checkAllMonitors() {

        System.out.println("Running scheduled health check...");

        List<Monitor> monitors = monitorRepository.findAll();

        for (Monitor monitor : monitors) {
            checkMonitorAsync(monitor);
        }
    }

    @Async
    public void checkMonitorAsync(Monitor monitor) {

        long startTime = System.currentTimeMillis();

        try {
            URL url = new URL(monitor.getUrl());

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            long endTime = System.currentTimeMillis();

            monitor.setResponseTime(endTime - startTime);
            monitor.setLastChecked(LocalDateTime.now());

            if (responseCode >= 200 && responseCode < 400) {
                monitor.setStatus("UP");
            } else {
                monitor.setStatus("DOWN");
            }

        } catch (Exception e) {

            monitor.setStatus("DOWN");
            monitor.setResponseTime(-1L);
            monitor.setLastChecked(LocalDateTime.now());
        }

        monitorRepository.save(monitor);

        System.out.println(
                monitor.getName() +
                        " | Status: " + monitor.getStatus() +
                        " | Response Time: " + monitor.getResponseTime() + " ms"
        );
    }
}