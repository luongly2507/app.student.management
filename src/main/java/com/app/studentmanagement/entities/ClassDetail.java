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
@Table(name="class_detail")
@NamedQuery(name="ClassDetail.findAll", query="SELECT c FROM ClassDetail c")
public class ClassDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    //bi-directional many-to-one association to Class
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id")
    private Class clazz;

    //bi-directional many-to-one association to Student
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;

}