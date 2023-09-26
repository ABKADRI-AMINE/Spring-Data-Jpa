package com.example.springdatajpabyysf.web;

import com.example.springdatajpabyysf.entities.Patient;
import com.example.springdatajpabyysf.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController//RestController c'est un controller qui va nous permettre de retourner des donnees en format JSON ou XML (par defaut c'est JSON)
public class PatientsController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")//GetMapping("/patients") c'est une methode qui va nous permettre de recuperer tous les patients en format JSON ou XML (par defaut c'est JSON)
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{id}")//GetMapping("/patients/{id}") c'est une methode qui va nous permettre de recuperer un patient par son id en format JSON ou XML (par defaut c'est JSON)
    public Patient patientById(@PathVariable Long id){//@PathVariable Long id c'est une methode qui va nous permettre de recuperer l'id du patient
        return patientRepository.findById(id).get();
    }
}
