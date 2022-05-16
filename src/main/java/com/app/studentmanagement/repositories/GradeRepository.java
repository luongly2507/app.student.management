package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.Grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer> {
    
}
