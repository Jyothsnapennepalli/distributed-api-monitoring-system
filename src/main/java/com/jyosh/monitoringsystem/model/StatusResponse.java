package com.jyosh.monitoringsystem.model;

public class StatusResponse {

    private String status;
    private String application;

    public StatusResponse(String status, String application) {
        this.status = status;
        this.application = application;
    }

    public String getStatus() {
        return status;
    }

    public String getApplication() {
        return application;
    }
}