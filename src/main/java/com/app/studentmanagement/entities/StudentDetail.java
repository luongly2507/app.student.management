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
@Table(name="student_detail")
@NamedQuery(name="StudentDetail.findAll", query="SELECT sd FROM StudentDetail sd")
public class StudentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(unique=true, nullable=false)
    private int studentID;

    //bi-directional many-to-one association to Semester
    @OneToMany(mappedBy="student_detail")
    private Set<int> semesterID;

    //bi-directional many-to-one association to Transcript
    @OneToMany(mappedBy="student_detail")
    private Set<int> transcriptID;

    @Column (nullable=false)
    private double gpa;
}