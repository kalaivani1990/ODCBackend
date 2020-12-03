package com.onlineDoctorConsultation.BackendODC.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineDoctorConsultation.BackendODC.Model.Consultant;
import com.onlineDoctorConsultation.BackendODC.Repository.ConsultantRepository;

@Service
public class ConsultantDAO {

	@Autowired
	ConsultantRepository consultantRepository;
	

	/* to create a new member */
	public Consultant save(Consultant consultant) {
		return consultantRepository.save(consultant);
	}
	
	/* get consultant by email */
	public Consultant getConsultantByName(String name) {
		return consultantRepository.findByName(name);
	}
	
}
