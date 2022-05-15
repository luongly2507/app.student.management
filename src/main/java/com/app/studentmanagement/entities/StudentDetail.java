
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
@Table(name="student_detail")
@NamedQuery(name="StudentDetail.findAll", query="SELECT s FROM StudentDetail s")
public class StudentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(precision=53)
    private double gpa;

    //bi-directional many-to-one association to Semester
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="semester_id")
    private Semester semester;

    //bi-directional many-to-one association to Student
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;

    //bi-directional many-to-one association to Transcript
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transcript_id")
    private Transcript transcript;


}