package com.app.management.student.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.management.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    @Query(value="SELECT * FROM student s WHERE s.id IN (SELECT student_id FROM class_detail WHERE semester_id = ?1 AND class_id = ?2)",
            countQuery = "SELECT COUNT(*) FROM student s WHERE s.id IN (SELECT student_id FROM class_detail WHERE semester_id = ?1 AND class_id = ?2)",
            nativeQuery =true)
    Page<Student> findBySemesterIdAndClassId(int semesterId, int classId, Pageable pageable);
    @Query (value="SELECT COUNT(*) FROM student s WHERE s.id IN (SELECT student_id FROM class_detail WHERE semester_id = ?1 AND class_id = ?2)",nativeQuery =true)
    long countBySemesterIdAndClassId(int semesterId, int classId);
    Optional<Student> findByEmail(String email);
}
