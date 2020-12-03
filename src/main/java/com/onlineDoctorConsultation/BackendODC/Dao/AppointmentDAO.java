package com.onlineDoctorConsultation.BackendODC.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineDoctorConsultation.BackendODC.Model.Appointment;
import com.onlineDoctorConsultation.BackendODC.Model.Doctor;
import com.onlineDoctorConsultation.BackendODC.Repository.AppointmentRepository;

@Service
public class AppointmentDAO {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	

	/* to create a new appointment */
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	/* get consultant by names of doctor and consultant */
	public Appointment getAppointmentByName(String doctorName, String consultantName) {
		return appointmentRepository.findByName(doctorName,consultantName);
	}

	/* to list existing doctors */
	public List<Appointment> findAllAappointmentByName(String doctorName) {
		return appointmentRepository.findAllAappointmentByName(doctorName);
	}
}
