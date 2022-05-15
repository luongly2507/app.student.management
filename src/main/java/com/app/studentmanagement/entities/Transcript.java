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
@Table(name="transcript")
@NamedQuery(name="Transcript.findAll", query="SELECT t FROM Transcript t")
public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(name="score_fifteen_minutes", precision=53)
    private double scoreFifteenMinutes;

    @Column(name="score_one_period", precision=53)
    private double scoreOnePeriod;

    //bi-directional many-to-one association to StudentDetail
    @OneToMany(mappedBy="transcript")
    private Set<StudentDetail> studentDetails;

    //bi-directional many-to-one association to Subject
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="subject_id")
    private Subject subject;



}