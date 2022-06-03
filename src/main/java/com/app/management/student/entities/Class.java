package com.app.management.student.entities;


import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="class", uniqueConstraints = @UniqueConstraint(columnNames = {"name","grade_id"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Class {
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

	//bi-directional many-to-one association to ClassDetail
	@OneToMany(mappedBy="clazz")
	private Set<ClassDetail> classDetails;

	public ClassDetail addClassDetail(ClassDetail classDetail) {
		getClassDetails().add(classDetail);
		classDetail.setClazz(this);
		return classDetail;
	}

	public ClassDetail removeClassDetail(ClassDetail classDetail) {
		getClassDetails().remove(classDetail);
		classDetail.setClazz(null);
		return classDetail;
	}

}