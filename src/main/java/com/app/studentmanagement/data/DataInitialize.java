package com.app.studentmanagement.data;

import java.util.Arrays;
import java.util.Set;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Role;
import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.repositories.RoleRepository;
import com.app.studentmanagement.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class DataInitialize implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private void initRole() {
        roleRepository.saveAll(
                Arrays.asList(
                        Role.builder()
                                .name("ROLE_USER")
                                .build(),
                        Role.builder()
                                .name("ROLE_TEACHER")
                                .build(),
                        Role.builder()
                                .name("ROLE_PRINCIPAL")
                                .build(),
                        Role.builder()
                                .name("ROLE_HR")
                                .build()));
    }

    private void initUser() {
        userRepository.saveAll(
                Arrays.asList(
                        User.builder()
                                .email("teacherA@gmail.com")
                                .password(passwordEncoder.encode("12345678"))
                                .fullName("Teacher A")
                                .roles(Arrays.asList(roleRepository.findByName("ROLE_TEACHER").get()))
                                .build(),
                        User.builder()
                                .email("teacherB@gmail.com")
                                .password(passwordEncoder.encode("12345678"))
                                .fullName("Teacher B")
                                .roles(Arrays.asList(roleRepository.findByName("ROLE_TEACHER").get()))
                                .build(),
                        User.builder()
                                .email("hrA@gmail.com")
                                .password(passwordEncoder.encode("12345678"))
                                .fullName("Human Resource A")
                                .roles(Arrays.asList(roleRepository.findByName("ROLE_HR").get()))
                                .build(),
                        User.builder()
                                .email("hrB@gmail.com")
                                .password(passwordEncoder.encode("12345678"))
                                .fullName("Human Resource B")
                                .roles(Arrays.asList(roleRepository.findByName("ROLE_HR").get()))
                                .build(),
                        User.builder()
                                .email("principalA@gmail.com")
                                .password(passwordEncoder.encode("12345678"))
                                .fullName("Principal A")
                                .roles(Arrays.asList(roleRepository.findByName("ROLE_PRINCIPAL").get()))
                                .build()
                        ));
    }

    @Override
    public void run(String... args) throws Exception {
        initRole();
        initUser();
    }

}
