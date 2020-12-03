package com.onlineDoctorConsultation.BackendODC.Repository;


import com.onlineDoctorConsultation.BackendODC.Model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
	
	@Query("FROM #{#entityName} WHERE user_name = ?1")
	Consultant findByName(String username);

}
