package com.app.studentmanagement.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.Grade;
import com.app.studentmanagement.entities.Role;
import com.app.studentmanagement.entities.Semester;
import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.entities.Class;
import com.app.studentmanagement.repositories.GradeRepository;
import com.app.studentmanagement.repositories.RoleRepository;
import com.app.studentmanagement.repositories.SemesterRepository;
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
        SemesterRepository semesterRepository;

        @Autowired
        GradeRepository gradeRepository;

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
                                                                .roles(Arrays.asList(roleRepository
                                                                                .findByName("ROLE_TEACHER").get()))
                                                                .build(),
                                                User.builder()
                                                                .email("teacherB@gmail.com")
                                                                .password(passwordEncoder.encode("12345678"))
                                                                .fullName("Teacher B")
                                                                .roles(Arrays.asList(roleRepository
                                                                                .findByName("ROLE_TEACHER").get()))
                                                                .build(),
                                                User.builder()
                                                                .email("hrA@gmail.com")
                                                                .password(passwordEncoder.encode("12345678"))
                                                                .fullName("Human Resource A")
                                                                .roles(Arrays.asList(roleRepository
                                                                                .findByName("ROLE_HR").get()))
                                                                .build(),
                                                User.builder()
                                                                .email("hrB@gmail.com")
                                                                .password(passwordEncoder.encode("12345678"))
                                                                .fullName("Human Resource B")
                                                                .roles(Arrays.asList(roleRepository
                                                                                .findByName("ROLE_HR").get()))
                                                                .build(),
                                                User.builder()
                                                                .email("principalA@gmail.com")
                                                                .password(passwordEncoder.encode("12345678"))
                                                                .fullName("Principal A")
                                                                .roles(Arrays.asList(roleRepository
                                                                                .findByName("ROLE_PRINCIPAL").get()))
                                                                .build()));
        }

        private void initSemester() {
                semesterRepository.saveAll(
                                Arrays.asList(
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2020-02-01"))
                                                                .dateEnd(LocalDate.parse("2020-07-01"))
                                                                .name("Học kì I")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2020-07-01"))
                                                                .dateEnd(LocalDate.parse("2021-01-01"))
                                                                .name("Học kì II")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2021-02-01"))
                                                                .dateEnd(LocalDate.parse("2021-07-01"))
                                                                .name("Học kì I")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2021-07-01"))
                                                                .dateEnd(LocalDate.parse("2022-01-01"))
                                                                .name("Học kì II")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2022-02-01"))
                                                                .dateEnd(LocalDate.parse("2022-07-01"))
                                                                .name("Học kì I")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2022-07-01"))
                                                                .dateEnd(LocalDate.parse("2023-01-01"))
                                                                .name("Học kì II")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2023-02-01"))
                                                                .dateEnd(LocalDate.parse("2023-07-01"))
                                                                .name("Học kì I")
                                                                .build(),
                                                Semester.builder()
                                                                .dateStart(LocalDate.parse("2023-07-01"))
                                                                .dateEnd(LocalDate.parse("2024-01-01"))
                                                                .name("Học kì II")
                                                                .build()

                                ));
        }
        private void initGradesAndClasses(){
                gradeRepository.saveAll(
                        Arrays.asList(
                                Grade.builder()
                                .name("10")
                                .clazzs(
                                        Set.of(
                                                Class.builder()
                                                        .name("A1")
                                                        .build(),
                                                Class.builder()
                                                        .name("A2")
                                                        .build() ,      
                                                Class.builder()
                                                        .name("A3")
                                                        .build() ,
                                                Class.builder()
                                                        .name("A4")
                                                        .build() 
                                                ))
                                .build(),
                                Grade.builder()
                                .name("11")
                                .clazzs(
                                        Set.of(
                                                Class.builder()
                                                        .name("A1")
                                                        .build(),
                                                Class.builder()
                                                        .name("A2")
                                                        .build() ,      
                                                Class.builder()
                                                        .name("A3")
                                                        .build() ,
                                                Class.builder()
                                                        .name("A4")
                                                        .build() 
                                                ))
                                .build(),
                                Grade.builder()
                                .name("12")
                                .clazzs(
                                        Set.of(
                                                Class.builder()
                                                        .name("A1")
                                                        .build(),
                                                Class.builder()
                                                        .name("A2")
                                                        .build() ,      
                                                Class.builder()
                                                        .name("A3")
                                                        .build() ,
                                                Class.builder()
                                                        .name("A4")
                                                        .build() 
                                                ))
                                .build()

                        )
                );
        }
        
        
        @Override
        public void run(String... args) throws Exception {
                initRole();
                initUser();
                initSemester();
                initGradesAndClasses();
        }

}
