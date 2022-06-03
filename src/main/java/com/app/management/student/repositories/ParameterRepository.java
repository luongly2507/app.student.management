package com.app.management.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.management.student.entities.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter,Integer>{
    
}
