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
@Table(name="subject",uniqueConstraints = @UniqueConstraint(columnNames = {"name","grade_id"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(columnDefinition="NVARCHAR(100)")
	private String name;

	//bi-directional many-to-one association to Grade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="grade_id")
	private Grade grade;

	//bi-directional many-to-one association to Transcript
	@OneToMany(mappedBy="subject")
	private Set<Transcript> transcripts;

	public Transcript addTranscript(Transcript transcript) {
		getTranscripts().add(transcript);
		transcript.setSubject(this);
		return transcript;
	}

	public Transcript removeTranscript(Transcript transcript) {
		getTranscripts().remove(transcript);
		transcript.setSubject(null);
		return transcript;
	}

}