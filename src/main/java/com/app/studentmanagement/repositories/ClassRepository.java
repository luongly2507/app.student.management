package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class,Integer>{

}