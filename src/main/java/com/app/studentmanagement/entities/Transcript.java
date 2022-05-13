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
@Table(name="transcript")
@NamedQuery(name="Transcript.findAll", query="SELECT t FROM Transcript t")
public class Transcript implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(nullable=true)
    private String score_fifteen_minutes;

    @Column(nullable=true)
    private String score_one_period;

    //bi-directional many-to-one association to Subject
    @OneToMany(mappedBy="transcript")
    private Set<int> subjectID;

}