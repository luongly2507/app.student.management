package com.app.management.student.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.management.student.entities.ClassDetail;

@Repository
public interface ClassDetailRepository extends JpaRepository<ClassDetail,Integer>{
    @Query(value="SELECT * FROM class_detail WHERE semester_id = ?1 AND class_id = ?2 AND student_id = ?3", nativeQuery=true)
    Optional<ClassDetail> findBySemesterIdAndClassIdAndStudentId(int semesterId, int classId, int studentId);
    
}
