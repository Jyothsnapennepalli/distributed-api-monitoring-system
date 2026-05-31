package com.jyosh.monitoringsystem.model;

public class Monitor {

    private Long id;
    private String name;
    private String url;
    private String status;

    public Monitor(Long id, String name, String url, String status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }
}