package com.infosys.bnsf.timetrackerassist.repository;

import com.infosys.bnsf.timetrackerassist.model.Effort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffortRepository extends JpaRepository<Effort, String> {
}
