package com.app.management.student.mappers;

import com.app.management.student.entities.Score;
import com.app.management.student.payloads.requests.CreateScoreRequest;
import com.app.management.student.payloads.requests.UpdateScoreRequest;
import com.app.management.student.payloads.responses.ScoreResponse;

public interface ScoreMapper {
    public ScoreResponse toScoreResponse(Score score);
    public Score toScore(CreateScoreRequest createScoreRequest);
    public Score toScore(int id, UpdateScoreRequest updateScoreRequest);
}
