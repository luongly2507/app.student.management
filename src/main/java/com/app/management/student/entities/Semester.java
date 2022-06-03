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
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="semester", uniqueConstraints = @UniqueConstraint(columnNames = {"name","yearStart","yearEnd"}))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(columnDefinition="NVARCHAR(100)")
	private String name;

	@Column
	private int yearStart;

	@Column
	private int yearEnd;
	//bi-directional many-to-one association to ClassDetail
	@OneToMany(mappedBy="semester", cascade= CascadeType.ALL)
	private Set<ClassDetail> classDetails;

	public ClassDetail addClassDetail(ClassDetail classDetail) {
		getClassDetails().add(classDetail);
		classDetail.setSemester(this);
		return classDetail;
	}

	public ClassDetail removeClassDetail(ClassDetail classDetail) {
		getClassDetails().remove(classDetail);
		classDetail.setSemester(null);
		return classDetail;
	}

}