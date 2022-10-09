package com.hkizilbulak.service;

import com.hkizilbulak.entity.Student;
import com.hkizilbulak.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
