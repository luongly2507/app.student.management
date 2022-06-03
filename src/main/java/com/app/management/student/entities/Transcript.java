package com.app.management.student.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="transcript",uniqueConstraints = @UniqueConstraint(columnNames = {"subject_id","student_id"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transcript {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Subject subject;

	@OneToMany(mappedBy="transcript")
	private Set<TranscriptDetail> transcriptDetails;

	public TranscriptDetail addTranscriptDetail(TranscriptDetail transcriptDetail) {
		getTranscriptDetails().add(transcriptDetail);
		transcriptDetail.setTranscript(this);
		return transcriptDetail;
	}

	public TranscriptDetail removeTranscriptDetail(TranscriptDetail transcriptDetail) {
		getTranscriptDetails().remove(transcriptDetail);
		transcriptDetail.setTranscript(null);
		return transcriptDetail;
	}

}