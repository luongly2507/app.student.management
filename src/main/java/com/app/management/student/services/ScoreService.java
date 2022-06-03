package com.app.management.student.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.management.student.payloads.requests.CreateScoreRequest;
import com.app.management.student.payloads.requests.UpdateScoreRequest;
import com.app.management.student.payloads.responses.ScoreResponse;

public interface ScoreService {
    public List<ScoreResponse> findAll(Pageable pageable);
    public ScoreResponse findById(int id);
    public ScoreResponse create(CreateScoreRequest createScoreRequest);
    public void update(int id, UpdateScoreRequest updateScoreRequest);
    public void delete(int id);
    public long count();
}
