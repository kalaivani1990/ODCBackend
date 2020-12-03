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

import com.onlineDoctorConsultation.BackendODC.Dao.AppointmentDAO;
import com.onlineDoctorConsultation.BackendODC.Model.Appointment;
import com.onlineDoctorConsultation.BackendODC.Model.Doctor;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentDAO appointmentDAO;
	
	/* to create a new appointment */
	@PostMapping("/createAppointment")
	public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) throws IOException {
		Appointment result =	appointmentDAO.getAppointmentByName(appointment.getDoctorName(),appointment.getPatientName());
		 if(result == null) {
			 return ResponseEntity.ok(appointmentDAO.save(appointment));
		 }
		 
		 result.setDateofappointment(appointment.getDateofappointment());
		 result.setDoctorName(appointment.getDoctorName());
		 result.setPatientName(appointment.getPatientName());
		 result.setProblems(appointment.getProblems());
		 result.setStatus(appointment.getStatus());
		 
		 Appointment updateAppointment = appointmentDAO.save(result);
		 return ResponseEntity.ok().body(updateAppointment);
		
	}
	
	/* to list existing members */
	@GetMapping("/allDoctors/{doctorName}")
	public List<Appointment> getAllDoctors(@PathVariable(value = "doctorName") String doctorName) {
		return appointmentDAO.findAllAappointmentByName(doctorName);
	}

}
