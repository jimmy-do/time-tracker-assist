package com.infosys.bnsf.timetrackerassist.service;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Application;
import com.infosys.bnsf.timetrackerassist.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    public List<Application> getAllApplications() {

        return repo.findAll();
    }

    public Application getApplicationById(String appName) throws ResourceNotFoundException {

        Optional<Application> foundApplication = repo.findById(appName);

        if(foundApplication.isEmpty()){
            throw new ResourceNotFoundException("Application does not exist.");
        }

        return foundApplication.get();
    }

    // Create
    public Application createApplication(Application application, String appName) throws Exception {

        if(repo.existsById(appName)){
            throw new Exception("This applicant with ID " + appName + " already exists.");
        }

        return repo.save(application);
    }

    // Update
    public Application updateApplication(Application application, String appName) throws ResourceNotFoundException {

        Optional<Application> foundApplication = repo.findById(appName);

        if (foundApplication.isEmpty()) {
            throw new ResourceNotFoundException("Customer with ID " + appName + " does not exist, no records were updated.");
        }

        Application editApplication = foundApplication.get();
        editApplication.setArea(application.getArea());
        editApplication.setManagerName(application.getManagerName());
        editApplication.setMaintId(application.getMaintId());
        editApplication.setMaintTs(application.getMaintTs());

        return repo.save(editApplication);
    }

    // Delete
    public void deleteApplication( String appName) throws ResourceNotFoundException {

        Optional<Application> foundApplication = repo.findById(appName);

        if(foundApplication.isEmpty()) {
            throw new ResourceNotFoundException("Applicant does not exist, no records were deleted.");
        }

        repo.deleteById(appName);
    }
}
