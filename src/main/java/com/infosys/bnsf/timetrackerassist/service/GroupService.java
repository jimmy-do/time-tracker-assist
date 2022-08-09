package com.infosys.bnsf.timetrackerassist.service;

import com.infosys.bnsf.timetrackerassist.exceptions.ResourceNotFoundException;
import com.infosys.bnsf.timetrackerassist.model.Group;
import com.infosys.bnsf.timetrackerassist.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository repo;

    public List<Group> getAllGroups(){
        return repo.findAll();
    }

    public Group getGroupById(Long groupId) throws ResourceNotFoundException {

        Optional<Group> foundGroup = repo.findById(groupId);

        if(foundGroup.isEmpty()){
            throw new ResourceNotFoundException("Group by ID " + groupId + " does not exist.");
        }

        return foundGroup.get();
    }

    // Create
    public Group createGroup(Group group) {

        group.setGroupId(-1L);
        return repo.save(group);
    }

    // Update
    public Group updateGroup(Group group, Long groupId) throws ResourceNotFoundException {

        Optional<Group> foundGroup = repo.findById(groupId);

        if (foundGroup.isEmpty()) {

            throw new ResourceNotFoundException("Group with ID " + groupId + " does not exist, no records were updated.");
        }

        Group editGroup = foundGroup.get();
        editGroup.setGroupId(group.getGroupId());
        editGroup.setGroupName(group.getGroupName());

        return repo.save(editGroup);
    }

    // Delete
    public void deleteGroup(Long groupId) throws ResourceNotFoundException {

        Optional<Group> foundGroup = repo.findById(groupId);

        if(foundGroup.isEmpty()) {
            throw new ResourceNotFoundException("Group does not exist, no records were deleted.");
        }

        repo.deleteById(groupId);
    }
}
