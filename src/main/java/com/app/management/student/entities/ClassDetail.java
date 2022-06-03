package com.app.management.student.entities;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="class_detail",uniqueConstraints = @UniqueConstraint(columnNames = {"class_id","student_id","semester_id"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Class
	@ManyToOne(fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Class clazz;

	//bi-directional many-to-one association to Semester
	@ManyToOne(fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="semester_id")
	private Semester semester;

	//bi-directional many-to-one association to Student
	@ManyToOne(fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;

}