package com.example.springdatajpabyysf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@Table(name = "PATIENTS")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM", length = 25)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;
}
