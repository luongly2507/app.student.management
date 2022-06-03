package com.app.management.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.management.student.entities.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer>{
    
}
