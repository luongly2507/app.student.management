package com.app.management.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="transcript_detail",uniqueConstraints = @UniqueConstraint(columnNames = {"score_id","transcript_id"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TranscriptDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="score_value", precision=53)
	@Min(0)
	@Max(10)
	private double scoreValue;

	//bi-directional many-to-one association to Score
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="score_id")
	private Score score;

	//bi-directional many-to-one association to Transcript
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transcript_id")
	private Transcript transcript;

}