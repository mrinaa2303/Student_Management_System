package com.example.student.controller;

import java.util.List;
import java.util.Optional;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/students")
public class StudentController {
 
    private final StudentService service;
    private final StudentRepository repo;

    public StudentController(StudentService service, StudentRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping("/signup")
    public Student signup(@RequestBody Student student) {
        return repo.save(student);
    }
    @PostMapping("/login")
    public Object login(@RequestBody Student student) {

        Optional<Student> existingUser = repo.findByEmail(student.getEmail());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(student.getPassword())) {
            return existingUser.get();
        }
        return "Invalid Credentials";
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
}
