package com.infosys.bnsf.timetrackerassist.controller;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Group;
import com.infosys.bnsf.timetrackerassist.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api")
@RestController
public class GroupController {

    @Autowired
    private GroupService service;

    @GetMapping("/group/findall")
    public ResponseEntity<List<Group>> findAllApplications() {

        return ResponseEntity.ok().body(service.getAllGroups());
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long groupId) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.getGroupById(groupId));
    }

    @PostMapping("/group/create")
    public ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws Exception {

        return ResponseEntity.ok().body(service.createGroup(group));
    }

    @PutMapping("/group/update")
    public ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(service.updateGroup(group, group.getGroupId()));
    }

    @DeleteMapping("/group/delete/{groupId}")
    public ResponseEntity<Object> deleteApplicationById(@PathVariable Long groupId) throws ResourceNotFoundException {

        service.deleteGroup(groupId);
        return ResponseEntity.ok().body("Group with ID: " + groupId + " deleted.");
    }
}

