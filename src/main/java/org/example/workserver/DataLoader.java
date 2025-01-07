//package org.example.workserver;
//
//import org.example.workserver.entity.User2;
//import org.example.workserver.enums.Role;
//import org.example.workserver.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        Optional<User2> existingUser = userRepository.findByUsername("Днамир");
//        if (!existingUser.isPresent()) {
//            User2 admin = new User2();
//            admin.setUsername("Дамир");
//            admin.setPassword(passwordEncoder.encode("2"));
//            admin.setEmail("admin2@example.com");
//            admin.setRole(Role.ADMIN);
//            userRepository.save(admin);
//        }
//    }
//}
