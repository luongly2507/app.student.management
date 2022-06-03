package com.app.management.student.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.management.student.entities.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer>{

    Optional<Grade> findByName(String string);
    
}
