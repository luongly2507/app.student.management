package com.app.studentmanagement.repositories;

import java.util.List;

import com.app.studentmanagement.entities.Semester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer>{

    @Query("SELECT s FROM Semester s WHERE YEAR(dateStart) = :year OR YEAR(dateEnd) = :year ")
    List<Semester> findByYear(@Param("year") int year);

}