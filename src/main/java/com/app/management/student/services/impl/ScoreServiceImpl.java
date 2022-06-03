package com.app.management.student.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.ScoreMapper;
import com.app.management.student.payloads.requests.CreateScoreRequest;
import com.app.management.student.payloads.requests.UpdateScoreRequest;
import com.app.management.student.payloads.responses.ScoreResponse;
import com.app.management.student.repositories.ScoreRepository;
import com.app.management.student.services.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    ScoreMapper scoreMapper;
    
    @Override
    public List<ScoreResponse> findAll(Pageable pageable) {
        return scoreRepository
                .findAll(pageable)
                .map(score->scoreMapper.toScoreResponse(score))
                .toList();
    }

    @Override
    public ScoreResponse findById(int id) {
        return scoreMapper.toScoreResponse(
            scoreRepository.findById(id).orElseThrow(()-> new NotFoundException("Không tìm thấy điểm này!")));
    }

    @Override
    public ScoreResponse create(CreateScoreRequest createScoreRequest) {
        return scoreMapper.toScoreResponse(
            scoreRepository.save(scoreMapper.toScore(createScoreRequest)
        ));
    }

    @Override
    public void delete(int id) {
        scoreRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateScoreRequest updateScoreRequest) {
        scoreRepository.save(scoreMapper.toScore(id,updateScoreRequest));

    }

    @Override
    public long count() {
        return  scoreRepository.count();
    }

    
}
