package com.app.studentmanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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

	@Column(name="date_end", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEnd;

	@Column(name="date_start", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateStart;

	@Column(nullable=false, columnDefinition = "NVARCHAR(255)")
	private String name;

	//bi-directional many-to-one association to StudentDetail
	@OneToMany(mappedBy="semester")
	private Set<StudentDetail> studentDetails;

}