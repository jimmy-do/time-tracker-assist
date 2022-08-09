package com.infosys.bnsf.timetrackerassist.service;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Task;
import com.infosys.bnsf.timetrackerassist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TaskRepository repo;

    public List<Task> getAllTasks() {

        return repo.findAll();
    }

    public Task findTaskById(String incidentId) throws ResourceNotFoundException {

        Optional<Task> foundTask = repo.findById(incidentId);

        if(foundTask.isEmpty()){
            throw new ResourceNotFoundException("Task does not exist.");
        }

        return foundTask.get();
    }

    // Create
    public Task createTask(Task task, String incidentId) throws Exception {

        if(repo.existsById(incidentId)) {

            throw new Exception("This task already exists.");
        }

        return repo.save(task);
    }

    public Task updateTask(Task tasks, String incident_Id) throws ResourceNotFoundException {

        Optional<Task> tasksDB = repo.findById(incident_Id);

        if(tasksDB.isEmpty()){

            throw new ResourceNotFoundException("Resource not found with Incident ID: "+ incident_Id);
        }

            Task updateTask = tasksDB.get();

            updateTask.setAppName(tasks.getAppName());
            updateTask.setGroupId(tasks.getGroupId());
            updateTask.setIncidentType(tasks.getIncidentType());
            updateTask.setSummary(tasks.getSummary());
            updateTask.setEmpId(tasks.getEmpId());
            updateTask.setSubmitDate(tasks.getSubmitDate());
            updateTask.setClosedDate(tasks.getClosedDate());
            updateTask.setImpact(tasks.getImpact());
            updateTask.setResolution(tasks.getResolution());
            updateTask.setResCateTier1(tasks.getResCateTier1());
            updateTask.setStatus(tasks.getStatus());
            updateTask.setRespondedDate(tasks.getRespondedDate());
            updateTask.setResCateTier3(tasks.getResCateTier3());
            updateTask.setTargetDate(tasks.getTargetDate());
            updateTask.setMaintId(tasks.getMaintId());
            updateTask.setMaintTs(tasks.getMaintTs());

            return repo.save(updateTask);
    }

    // Delete
    public void deleteTask(String incidentId) throws ResourceNotFoundException {

        Optional<Task> foundTask = repo.findById(incidentId);

        if(foundTask.isEmpty()) {

            throw new ResourceNotFoundException("Task does not exist.");
        }

        repo.deleteById(incidentId);
    }
}
