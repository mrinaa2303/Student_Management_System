package com.example.student.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;  

import com.example.student.repository.StudentRepository;
import com.example.student.model.Student;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }
    public Student saveStudent(Student student) {
        return repo.save(student);
    }
    
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    public Optional<Student> getStudentByEmail(String email) {
        return repo.findByEmail(email);
    }
}
