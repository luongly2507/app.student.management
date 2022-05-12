package com.app.studentmanagement.entities;

import java.io.Serializable;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="parameter")
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=50)
	private String name;

	@Column(length=20)
	private String value;
}