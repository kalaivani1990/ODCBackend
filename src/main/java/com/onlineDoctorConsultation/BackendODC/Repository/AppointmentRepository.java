package com.onlineDoctorConsultation.BackendODC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlineDoctorConsultation.BackendODC.Model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	@Query("FROM #{#entityName} WHERE doctor_name = ?1 AND patient_name = ?2")
	Appointment findByName(String doctorName, String consultantName);
	
	@Query("FROM #{#entityName} WHERE doctor_name = ?1")
	List<Appointment> findAllAappointmentByName(String doctorName);

}