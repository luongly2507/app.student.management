package com.app.studentmanagement.repositories;

import com.app.studentmanagement.entities.Transcript;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript,Integer> {

}
