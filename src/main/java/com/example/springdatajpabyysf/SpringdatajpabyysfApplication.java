package com.example.springdatajpabyysf;

import com.example.springdatajpabyysf.entities.Patient;
import com.example.springdatajpabyysf.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringdatajpabyysfApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpabyysfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null, "Haasan", new Date(), 2300, false));
		patientRepository.save(new Patient(null, "Amine", new Date(), 2333, true));
		patientRepository.save(new Patient(null, "Yassine", new Date(), 5433, false));
		patientRepository.save(new Patient(null, "Sarah", new Date(), 7373, true));
		patientRepository.save(new Patient(null, "yosra", new Date(), 3536, true));
        patientRepository.findAll().forEach(p -> {///findAll() pour recuperer tous les patients
			System.out.println(p.toString());
		});
		System.out.println("***********************");
		Patient patient = patientRepository.findById(4L).get();//get() pour recuperer le patient qui a l'id 4
		System.out.println(patient.getNom());
		System.out.println("***********************");
		Page<Patient> patients = patientRepository.findByNomContains("s",PageRequest.of(0,2));//findByNomContains c'est une methode qui va nous permettre de chercher un patient par son nom
		patients.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		System.out.println("***********************");
		List<Patient> patients2 = patientRepository.findByMalade(true);//findByMalade c'est une methode qui va nous permettre de chercher un patient par son malade
		patients2.forEach(p -> {
			System.out.println(p.toString());
		});
		System.out.println("***********************");
		List<Patient> patients3 = patientRepository.findByNomContainsAndMalade("s", true);//findByNomContainsAndMalade c'est une methode qui va nous permettre de chercher un patient par son nom et son malade
		patients3.forEach(p -> {
			System.out.println(p.toString());
		});
//		patientRepository.deleteById(5L);//deleteById() pour supprimer le patient qui a l'id 5
//		System.out.println("***********************");
//		List<Patient> patients4 = patientRepository.findAll();//findAll() pour recuperer tous les patients
//		patients4.forEach(p -> {
//			System.out.println(p.toString());
//		});
		System.out.println("***********************");
		Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0, 2));//PageRequest.of(0, 2) pour recuperer les deux premiers patients de la page 0 (la premiere page)
		System.out.println("Nombre de pages : " + pagePatients.getTotalPages());
		List<Patient> listPatients = pagePatients.getContent();
		listPatients.forEach(p -> {
			System.out.println(p.toString());

	});
	}
}
