package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.Parameter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter,Integer>{
    
}
