package com.infosys.bnsf.timetrackerassist.repository;

import com.infosys.bnsf.timetrackerassist.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
}
