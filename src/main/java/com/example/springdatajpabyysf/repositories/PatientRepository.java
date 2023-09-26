package com.example.springdatajpabyysf.repositories;

import com.example.springdatajpabyysf.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Page<Patient> findByNomContains(String name, Pageable pageable);//findByNomContains c'est une methode qui va nous permettre de chercher un patient par son nom
    public List<Patient> findByMalade(boolean b);//findByMalade c'est une methode qui va nous permettre de chercher un patient par son malade
    public  List<Patient> findByNomContainsAndMalade(String name, boolean b);//findByNomContainsAndMalade c'est une methode qui va nous permettre de chercher un patient par son nom et son malade
}

