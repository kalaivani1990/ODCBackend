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

import com.onlineDoctorConsultation.BackendODC.Dao.ConsultantDAO;
import com.onlineDoctorConsultation.BackendODC.Model.Consultant;
import com.onlineDoctorConsultation.BackendODC.Model.Member;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/consultant")
public class ConsultantController {
	
	@Autowired
	ConsultantDAO consultantDAO;
	
	/* to create a new member */
	@PostMapping("/createConsultant")
	public ResponseEntity<Consultant> createConsultant(@Valid @RequestBody Consultant consultant) throws IOException {
	 Consultant result =	consultantDAO.getConsultantByName(consultant.getUserName());
		 if(result == null) {
			 return ResponseEntity.ok(consultantDAO.save(consultant));
		 }
		 
		 result.setCity(consultant.getCity());
		 result.setFirstName(consultant.getFirstName());
		 result.setGender(consultant.getGender());
		 result.setLastName(consultant.getLastName());
		 result.setPhoneNumber(consultant.getPhoneNumber());
		 result.setPin(consultant.getPin());
		 result.setUserName(consultant.getUserName());
		 result.setDateofBirth(consultant.getDateofBirth());
		 result.setEmail(consultant.getEmail());
		 
		 Consultant updateConsultant = consultantDAO.save(result);
		 return ResponseEntity.ok().body(updateConsultant);
		
	}
	
	/* get consultant by email id */
	@GetMapping("/getConsultant/{name}")
	public ResponseEntity<Consultant> getConsultant(@PathVariable(value = "name") String name) throws IOException {
		return ResponseEntity.ok(consultantDAO.getConsultantByName(name));
	}
	
	

}
