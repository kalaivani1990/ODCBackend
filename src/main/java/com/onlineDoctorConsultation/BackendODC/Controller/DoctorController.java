package com.onlineDoctorConsultation.BackendODC.Controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineDoctorConsultation.BackendODC.Dao.DoctorDAO;
import com.onlineDoctorConsultation.BackendODC.Model.Doctor;
import com.onlineDoctorConsultation.BackendODC.Model.Member;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorDAO doctorDAO;
	
	/* to create a new member */
	@PostMapping("/createDoctor")
	public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) throws IOException {
		Doctor result =	doctorDAO.getDoctorByName(doctor.getUserName());
		 if(result == null) {
			 return ResponseEntity.ok(doctorDAO.save(doctor));
		 }
		 
		 result.setCity(doctor.getCity());
		 result.setFirstName(doctor.getFirstName());
		 result.setGender(doctor.getGender());
		 result.setLastName(doctor.getLastName());
		 result.setPhonenumber(doctor.getPhonenumber());
		 result.setPin(doctor.getPin());
		 result.setUserName(doctor.getUserName());
		 result.setDateofbirth(doctor.getDateofbirth());
		 result.setQualification(doctor.getQualification());
		 result.setRegistrationDetail(doctor.getRegistrationDetail());
		 result.setEmail(doctor.getEmail());
		 result.setExperience(doctor.getExperience());
		 
		 Doctor updateDoctor = doctorDAO.save(result);
		 return ResponseEntity.ok().body(updateDoctor);
		
	}
	
	/* get consultant by email id */
	@GetMapping("/getDoctor/{name}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable(value = "name") String name) throws IOException {
		return ResponseEntity.ok(doctorDAO.getDoctorByName(name));
	}
	
	/* to list existing members */
	@GetMapping("/allDoctors")
	public List<Doctor> getAllDoctors() {
		return doctorDAO.findAll();
	}

}
