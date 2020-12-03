package com.onlineDoctorConsultation.BackendODC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlineDoctorConsultation.BackendODC.Model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("FROM #{#entityName} WHERE user_name = ?1")
	Doctor findByName(String username);

}
