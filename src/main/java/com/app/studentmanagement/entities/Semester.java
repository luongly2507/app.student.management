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
@Table(name="semester")
@NamedQuery(name="Semester.findAll", query="SELECT s FROM Semester s")
public class Semester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_end", nullable=false)
	private Date dateEnd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_start", nullable=false)
	private Date dateStart;

	@Column(nullable=false)
	private String name;

	//bi-directional many-to-one association to StudentDetail
	@OneToMany(mappedBy="semester")
	private Set<StudentDetail> studentDetails;

}