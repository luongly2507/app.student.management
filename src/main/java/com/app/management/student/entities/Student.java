package com.app.management.student.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="student")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(columnDefinition="NVARCHAR(100)")
	private String address;

	@Column
	private LocalDate birthday;
	
	@Column(columnDefinition="NVARCHAR(100)")
	private String email;

	@Column(columnDefinition="NVARCHAR(10)")
	private String gender;

	@Column(columnDefinition="NVARCHAR(100)")
	private String name;

	//bi-directional many-to-one association to ClassDetail
	@OneToMany(mappedBy="student", cascade= CascadeType.ALL)
	@Builder.Default
	private Set<ClassDetail> classDetails = new HashSet<ClassDetail>();

	//bi-directional many-to-one association to Transcript
	@OneToMany(mappedBy="student")
	private Set<Transcript> transcripts;

	public ClassDetail addClassDetail(ClassDetail classDetail) {
		getClassDetails().add(classDetail);
		classDetail.setStudent(this);
		return classDetail;
	}

	public ClassDetail removeClassDetail(ClassDetail classDetail) {
		getClassDetails().remove(classDetail);
		classDetail.setStudent(null);
		return classDetail;
	}


	public Transcript addTranscript(Transcript transcript) {
		getTranscripts().add(transcript);
		transcript.setStudent(this);
		return transcript;
	}

	public Transcript removeTranscript(Transcript transcript) {
		getTranscripts().remove(transcript);
		transcript.setStudent(null);
		return transcript;
	}

}