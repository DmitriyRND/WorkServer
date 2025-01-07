package org.example.workserver.service;


import jakarta.transaction.Transactional;
import org.example.workserver.entity.User;
import org.example.workserver.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public void transferMoney(Long fromUserId, Long toUserId, Double amount) {
        User fromUserOptional = userRepository.findById(fromUserId).orElse(null);
        User toUserOptional = userRepository.findById(toUserId).orElse(null);


        if (fromUserOptional == null || toUserOptional == null) {
            log.error("One or both users are not found");
            return;
        }

        if (fromUserOptional.getBalance() < amount) {
            throw new IllegalArgumentException("Balance");
        }


        fromUserOptional.setBalance(fromUserOptional.getBalance() - amount);
        userRepository.save(fromUserOptional);


            toUserOptional.setBalance(toUserOptional.getBalance() + amount);
            userRepository.save(toUserOptional);

            log.error("Error during transfer money");




    }
    public User getCurrentAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = authentication.getName();

         return userRepository.findByUsername(nameUser).orElse(null);
    }

    public Long getUserIdByName(String name){
        return userRepository.findByUsername(name)
                .map(User::getId).orElse(-1L);
    }

}



