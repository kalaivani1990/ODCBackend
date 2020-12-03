package com.onlineDoctorConsultation.BackendODC;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

@SpringBootApplication
@EnableJpaAuditing
public class ODCBackend {

	@Value("${tomcat.port:8080}")
	private int port;
	
	@Value("${tomcat.contextPath:/backend-odc}")
	private String contextPath;
	
	
    
	public static void main(String[] args) {
		 SpringApplication.run(ODCBackend.class,args);
	}
	
	/**
     * enables AJP in embedded Tomcat.
     *
     * @return customizer
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return server -> {
            server.setContextPath(contextPath);
            server.setPort(port);
        };
    }
}
