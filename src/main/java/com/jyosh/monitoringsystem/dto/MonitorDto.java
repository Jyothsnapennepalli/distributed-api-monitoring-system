package com.jyosh.monitoringsystem.dto;

import java.time.LocalDateTime;

public class MonitorDto {

    private Long id;
    private String name;
    private String status;
    private Long responseTime;
    private LocalDateTime lastChecked;

    public MonitorDto() {
    }

    public MonitorDto(Long id,
                      String name,
                      String status,
                      Long responseTime,
                      LocalDateTime lastChecked) {

        this.id = id;
        this.name = name;
        this.status = status;
        this.responseTime = responseTime;
        this.lastChecked = lastChecked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }
}