package com.app.studentmanagement.entities;

import java.io.Serializable;
import java.util.Set;

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
@Table(name="class")
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(insertable=false, updatable=false)
    private String name;

    //bi-directional many-to-one association to Grade
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grade_id")
    private Grade grade;

    //bi-directional many-to-one association to ClassDetail
    @OneToMany(mappedBy="clazz")
    private Set<ClassDetail> classDetails;
}
