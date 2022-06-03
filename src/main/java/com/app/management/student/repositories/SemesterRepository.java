package com.app.management.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.management.student.entities.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer>{
    
}
