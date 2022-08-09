package com.infosys.bnsf.timetrackerassist.repository;

import com.infosys.bnsf.timetrackerassist.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
