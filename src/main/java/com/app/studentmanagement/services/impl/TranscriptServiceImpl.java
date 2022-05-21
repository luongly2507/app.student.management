package com.app.studentmanagement.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Transcript;
import com.app.studentmanagement.repositories.TranscriptRepository;
import com.app.studentmanagement.services.TranscriptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TranscriptServiceImpl implements TranscriptService{

    @Autowired
    TranscriptRepository transcriptRepository;

    @Override
    public Page<Transcript> findAll(Pageable pageable) {
        return transcriptRepository.findAll(pageable);
    }

    @Override
    public List<Transcript> findAll() {
        return transcriptRepository.findAll();
    }

    @Override
    public Transcript findById(int id) {
        return transcriptRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        transcriptRepository.deleteById(id);

    }

    @Override
    public Transcript save(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

}
