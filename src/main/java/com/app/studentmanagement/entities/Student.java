package com.app.studentmanagement.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date birthday;

	private String email;

	@Column(nullable=false)
	private String gender;

	@Column(nullable=false)
	private String name;

	//bi-directional many-to-one association to ClassDetail
	@OneToMany(mappedBy="student")
	private Set<ClassDetail> classDetails;

	//bi-directional many-to-one association to StudentDetail
	@OneToMany(mappedBy="student")
	private Set<StudentDetail> studentDetails;


}