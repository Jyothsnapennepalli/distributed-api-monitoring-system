package com.jyosh.monitoringsystem.exception;

public class MonitorNotFoundException extends RuntimeException {

    public MonitorNotFoundException(Long id) {
        super("Monitor not found with id: " + id);
    }
}