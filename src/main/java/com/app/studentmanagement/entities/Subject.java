package com.app.studentmanagement.entities;

import java.io.Serializable;
import javax.persistence.*;
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
@Table(name="subject")
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String name;

	@Column(name="score_type", nullable=false, length=20)
	private String scoreType;

	//bi-directional many-to-one association to Transcript
	@OneToMany(mappedBy="subject")
	private Set<Transcript> transcripts;


}