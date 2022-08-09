package com.infosys.bnsf.timetrackerassist.repository;

import com.infosys.bnsf.timetrackerassist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findById(String incidentId);
    boolean existsById(String incidentId);
    void deleteById(String incidentId);
}
