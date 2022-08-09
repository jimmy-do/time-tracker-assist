package com.infosys.bnsf.timetrackerassist.controller;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Application;
import com.infosys.bnsf.timetrackerassist.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @GetMapping("/application/findall")
    public ResponseEntity<List<Application>> findAllApplications() {

        return ResponseEntity.ok().body(service.getAllApplications());
    }

    @GetMapping("/application/{appName}")
    public ResponseEntity<Application> getApplicationById(@PathVariable String appName) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.getApplicationById(appName));
    }

    @PostMapping("/application/create")
    public ResponseEntity<Application> createApplication(@Valid @RequestBody Application application) throws Exception {

        return ResponseEntity.ok().body(service.createApplication(application, application.getAppName()));
    }

    @PutMapping("/application/update")
    public ResponseEntity<Application> updateApplication(@Valid @RequestBody Application application) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.updateApplication(application, application.getAppName()));
    }

    @DeleteMapping("/application/delete/{appName}")
    public ResponseEntity<Object> deleteApplicationById(@PathVariable String appName) throws ResourceNotFoundException {

        service.deleteApplication(appName);
        return ResponseEntity.ok().body("Application with ID: " + appName + " deleted.");
    }
}
