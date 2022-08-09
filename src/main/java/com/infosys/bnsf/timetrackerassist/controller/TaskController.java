package com.infosys.bnsf.timetrackerassist.controller;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Task;
import com.infosys.bnsf.timetrackerassist.model.Task;
import com.infosys.bnsf.timetrackerassist.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class TaskController {

    @Autowired
    private TasksService service;

    @GetMapping("/task/findall")
    public ResponseEntity<List<Task>> findAllTasks() {

        return ResponseEntity.ok().body(service.getAllTasks());
    }

    @GetMapping("/task/{incidentId}")
    public ResponseEntity<Task> findTaskById(@PathVariable String incidentId) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.findTaskById(incidentId));
    }

    @PostMapping("/task/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) throws Exception {

        return ResponseEntity.ok().body(service.createTask(task, task.getIncidentId()));
    }

    @PutMapping("/task/update")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.updateTask(task, task.getIncidentId()));
    }

    @DeleteMapping("/task/delete/{incidentId}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable String incidentId) throws ResourceNotFoundException {

        service.deleteTask(incidentId);
        return ResponseEntity.ok().body("Task with ID: " + incidentId + " deleted.");
    }
}
