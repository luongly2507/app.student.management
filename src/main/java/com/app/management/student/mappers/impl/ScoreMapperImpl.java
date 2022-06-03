package com.app.management.student.mappers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Score;
import com.app.management.student.exceptions.NotFoundException;
import com.app.management.student.mappers.ScoreMapper;
import com.app.management.student.payloads.requests.CreateScoreRequest;
import com.app.management.student.payloads.requests.UpdateScoreRequest;
import com.app.management.student.payloads.responses.ScoreResponse;
import com.app.management.student.repositories.ScoreRepository;

@Component
public class ScoreMapperImpl  implements ScoreMapper{

    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public ScoreResponse toScoreResponse(Score score) {
        if (score == null) {
            return null;
        }
        return ScoreResponse.builder()
                .id(score.getId())
                .scoreType(score.getScoreType())
                .coeff(score.getScoreCoefficient())
                .build();
    }

    @Override
    public Score toScore(CreateScoreRequest createScoreRequest) {
        if (createScoreRequest == null) {
            return null;
        }
        return Score.builder()
                .scoreType(createScoreRequest.getName())
                .scoreCoefficient(createScoreRequest.getCoeff())
                .build();
    }

    @Override
    public Score toScore(int id, UpdateScoreRequest updateScoreRequest) {
        if (updateScoreRequest == null) {
            return null;
        }
        Score score = scoreRepository
            .findById(id)
            .orElseThrow(()-> new NotFoundException("Không tìm thấy khối này !"));
        score.setScoreType(updateScoreRequest.getName());
        score.setScoreCoefficient(updateScoreRequest.getCoeff());
        return score;
    }

}
