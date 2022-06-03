package com.app.management.student.entities;

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
@Table(name="grade")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	
	@Column(columnDefinition="NVARCHAR(100)", unique=true)
	private String name;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="grade", cascade= CascadeType.ALL )
	private Set<Class> clazzs;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="grade" , cascade= CascadeType.ALL )
	private Set<Subject> subjects;

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setGrade(this);
		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setGrade(null);
		return clazz;
	}

	public Subject addSubject(Subject subject) {
		getSubjects().add(subject);
		subject.setGrade(this);
		return subject;
	}

	public Subject removeSubject(Subject subject) {
		getSubjects().remove(subject);
		subject.setGrade(null);
		return subject;
	}

}