package com.app.management.student.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="score")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Score {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="score_coefficient")
	@Min(1)
	private int scoreCoefficient;

	@Column(name="score_type",columnDefinition = "NVARCHAR(100) UNIQUE")
	private String scoreType;

	//bi-directional many-to-one association to TranscriptDetail
	@OneToMany(mappedBy="score")
	private Set<TranscriptDetail> transcriptDetails;

	public TranscriptDetail addTranscriptDetail(TranscriptDetail transcriptDetail) {
		getTranscriptDetails().add(transcriptDetail);
		transcriptDetail.setScore(this);
		return transcriptDetail;
	}

	public TranscriptDetail removeTranscriptDetail(TranscriptDetail transcriptDetail) {
		getTranscriptDetails().remove(transcriptDetail);
		transcriptDetail.setScore(null);
		return transcriptDetail;
	}

}