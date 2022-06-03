package com.app.management.student.data;

import java.time.LocalDate;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.Class;
import com.app.management.student.entities.ClassDetail;
import com.app.management.student.entities.Grade;
import com.app.management.student.entities.Parameter;
import com.app.management.student.entities.Role;
import com.app.management.student.entities.Score;
import com.app.management.student.entities.Semester;
import com.app.management.student.entities.Student;
import com.app.management.student.entities.User;
import com.app.management.student.repositories.ClassRepository;
import com.app.management.student.repositories.GradeRepository;
import com.app.management.student.repositories.ParameterRepository;
import com.app.management.student.repositories.RoleRepository;
import com.app.management.student.repositories.ScoreRepository;
import com.app.management.student.repositories.SemesterRepository;
import com.app.management.student.repositories.StudentRepository;
import com.app.management.student.repositories.UserRepository;

@Transactional
@Component
public class DataInitialize implements CommandLineRunner {

        @Autowired
        SemesterRepository semesterRepository;

        @Autowired
        GradeRepository gradeRepository;
        @Autowired
        ScoreRepository scoreRepository;
        @Autowired
        ClassRepository classRepository;

        @Autowired
        ParameterRepository regulationRepository;

        @Autowired
        RoleRepository roleRepository;
        @Autowired
        StudentRepository studentRepository;
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
                                                                .name("Học kì I")
                                                                .yearStart(2018)
                                                                .yearEnd(2019)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì II")
                                                                .yearStart(2018)
                                                                .yearEnd(2019)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì I")
                                                                .yearStart(2019)
                                                                .yearEnd(2020)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì II")
                                                                .yearStart(2019)
                                                                .yearEnd(2020)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì I")
                                                                .yearStart(2020)
                                                                .yearEnd(2021)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì II")
                                                                .yearStart(2020)
                                                                .yearEnd(2021)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì I")
                                                                .yearStart(2021)
                                                                .yearEnd(2022)
                                                                .build(),
                                                Semester.builder()
                                                                .name("Học kì II")
                                                                .yearStart(2021)
                                                                .yearEnd(2022)
                                                                .build()

                                ));
        }

        private void initGrade() {

                gradeRepository.saveAll(
                                Arrays.asList(
                                                Grade.builder()
                                                                .name("10")
                                                                .build(),
                                                Grade.builder()
                                                                .name("11")
                                                                .build(),
                                                Grade.builder()
                                                                .name("12")
                                                                .build()

                                ));
        }

        private void initClass() {
                classRepository.saveAll(
                                Arrays.asList(
                                                Class.builder()
                                                                .name("A1")
                                                                .grade(gradeRepository.findByName("10").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A2")
                                                                .grade(gradeRepository.findByName("10").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A3")
                                                                .grade(gradeRepository.findByName("10").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A4")
                                                                .grade(gradeRepository.findByName("10").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A1")
                                                                .grade(gradeRepository.findByName("11").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A2")
                                                                .grade(gradeRepository.findByName("11").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A3")
                                                                .grade(gradeRepository.findByName("11").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A4")
                                                                .grade(gradeRepository.findByName("11").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A1")
                                                                .grade(gradeRepository.findByName("12").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A2")
                                                                .grade(gradeRepository.findByName("12").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A3")
                                                                .grade(gradeRepository.findByName("12").get())
                                                                .build(),
                                                Class.builder()
                                                                .name("A4")
                                                                .grade(gradeRepository.findByName("12").get())
                                                                .build()

                                ));
        }

        public void initParameter() {
                regulationRepository.saveAll(
                                Arrays.asList(
                                                Parameter.builder()
                                                                .name("minAge")
                                                                .value("15")
                                                                .build(),
                                                Parameter.builder()
                                                                .name("maxAge")
                                                                .value("20")
                                                                .build(),
                                                Parameter.builder()
                                                                .name("passScore")
                                                                .value("5")
                                                                .build(),
                                                Parameter.builder()
                                                                .name("classCount")
                                                                .value("40")
                                                                .build()

                                ));
        }public void initScore() {
                scoreRepository.saveAll(
                                Arrays.asList(
                                                Score.builder().scoreType("Điểm 15 phút").scoreCoefficient(1)
                                                                
                                                                .build(),
                                                                Score.builder().scoreType("Điểm 1 tiết").scoreCoefficient(2)
                                                                
                                                                .build()

                                ));
        }

    private void initStudent() {
        Student studentA = Student.builder()
                .name("Student A")
                .email("studentA@gmail.com")
                .birthday(LocalDate.of(2000, 11, 10))
                .address("Address")
                .gender("Nam")
                .build();
        studentA.addClassDetail(ClassDetail.builder().clazz(classRepository.findById(1).get()).semester(semesterRepository.findById(1).get()).build());
        Student studentB = Student.builder()
                .name("Student B")
                .email("studentB@gmail.com")
                .birthday(LocalDate.of(2000, 11, 10))
                .address("Address")
                .gender("Nam")
                .build();
        studentB.addClassDetail(ClassDetail.builder().clazz(classRepository.findById(1).get()).semester(semesterRepository.findById(1).get()).build());
        studentRepository.save(studentA);
        studentRepository.save(studentB);
    }

        @Override
        public void run(String... args) throws Exception {
                initRole();
                initUser();
                initSemester();
                initGrade();
                initClass();
                initParameter();
                initStudent();
                initScore();
        }

}
