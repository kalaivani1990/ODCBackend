package com.onlineDoctorConsultation.BackendODC.Model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "appointments")
@EntityListeners(AuditingEntityListener.class)
public class Appointment {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String doctorName;
private String patientName;
private String dateofappointment;
private String problems;
private String status;
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getDateofappointment() {
	return dateofappointment;
}
public void setDateofappointment(String dateofappointment) {
	this.dateofappointment = dateofappointment;
}
public String getProblems() {
	return problems;
}
public void setProblems(String problems) {
	this.problems = problems;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
