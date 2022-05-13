package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.StudentDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail,Integer>{

}
