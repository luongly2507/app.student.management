package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.ClassDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDetailRepository extends JpaRepository<ClassDetail,Integer>{

}