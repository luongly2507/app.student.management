package com.app.studentmanagement.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Transcript;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface TranscriptService{
    public Page<Transcript> findAll(Pageable pageable);
    public List<Transcript> findAll();
    public Transcript findById(int id);
    public void deleteById(int id);
    public Transcript save(Transcript transcript);
}
