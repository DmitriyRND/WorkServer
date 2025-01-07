package org.example.workserver;

import jakarta.annotation.PostConstruct;
import org.example.workserver.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkServerApplication {
//@Autowired
    RegistrationRepository registrationRepository;
    public static void main(String[] args) {
        SpringApplication.run(WorkServerApplication.class, args);
    }
//    @PostConstruct
//    public void deleteAllRegistrations() {
//        registrationRepository.deleteAll();
//    }
}
