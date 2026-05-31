package com.jyosh.monitoringsystem.controller;

import com.jyosh.monitoringsystem.model.Monitor;
import com.jyosh.monitoringsystem.model.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/api/status")
    public StatusResponse getStatus() {
        return new StatusResponse(
                "UP",
                "Distributed API Monitoring System"
        );
    }

    @GetMapping("/api/monitors")
    public List<Monitor> getMonitors() {

        return List.of(
                new Monitor(
                        1L,
                        "Google",
                        "https://google.com",
                        "UP"
                ),
                new Monitor(
                        2L,
                        "GitHub",
                        "https://github.com",
                        "UP"
                )
        );
    }
}