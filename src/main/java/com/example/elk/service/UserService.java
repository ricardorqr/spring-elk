package com.example.elk.service;

import com.example.elk.model.Role;
import com.example.elk.model.User;
import com.example.elk.repository.RoleRepository;
import com.example.elk.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.warn("User not found in DB");
            throw new UsernameNotFoundException("User not found in DB");
        }

        log.info("User found in DB: {}", user);

        List<SimpleGrantedAuthority> authorities = user.getRoles()
                                                       .stream()
                                                       .map(role -> new SimpleGrantedAuthority(role.getName()
                                                                                                   .getValue()))
                                                       .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User addRoleToUser(User user, Role role) {
        log.info("Add the role {} to the user {}", role.getName().getValue(), user.getUsername());
        User userFound = userRepository.findByUsername(user.getUsername());
        Role roleFound = roleRepository.findByName(role.getName());
        userFound.getRoles().add(roleFound);
        return userFound;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("ricardo123"));
        // $2a$10$01KY2xuPr8iNq3QokJ1c1OuUNZw6rPmqYQSjAFh91PY.pOnPP0MX2
    }

}
