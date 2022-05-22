package com.app.studentmanagement.repositories;

import java.util.Optional;

import com.app.studentmanagement.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String name);
    
}
