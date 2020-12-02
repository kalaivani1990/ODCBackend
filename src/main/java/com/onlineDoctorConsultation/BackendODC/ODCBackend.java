package com.onlineDoctorConsultation.BackendODC;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ODCBackend {

	public static void main(String[] args) {
		SpringApplication.run(ODCBackend.class, args);
	}
}
