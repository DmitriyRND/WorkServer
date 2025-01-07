package org.example.workserver.security;

import org.example.workserver.entity.User;
import org.example.workserver.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с именем '" + username + "' не найден"));
        return new CustomUserDetails(user);
    }
}
