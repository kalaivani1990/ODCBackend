package com.onlineDoctorConsultation.BackendODC.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineDoctorConsultation.BackendODC.Model.Doctor;
import com.onlineDoctorConsultation.BackendODC.Model.Member;
import com.onlineDoctorConsultation.BackendODC.Repository.DoctorRepository;

@Service
public class DoctorDAO {
	
	@Autowired
	DoctorRepository doctorRepository;
	

	/* to create a new doctor */
	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	/* get doctor by name */
	public Doctor getDoctorByName(String name) {
		return doctorRepository.findByName(name);
	}

	/* to list existing doctors */
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
}
