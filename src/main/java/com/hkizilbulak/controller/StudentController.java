package com.hkizilbulak.controller;

import com.hkizilbulak.entity.Student;
import com.hkizilbulak.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("Get All Students")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "All students listed"),
            @ApiResponse(code=400, message = "Missing or invalid request body"),
            @ApiResponse(code=500, message = "Internal Error")})
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @ApiOperation("Get a single student by id")
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Student found"),
            @ApiResponse(code=400, message = "Missing or invalid request body"),
            @ApiResponse(code=500, message = "Internal Error")})
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @ApiOperation("Save student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student saved successfully"),
            @ApiResponse(code=400, message = "Missing or invalid request body"),
            @ApiResponse(code=500, message = "Internal Error")})
    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @ApiOperation("Delete student")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student deleted successfully"),
            @ApiResponse(code=400, message = "Missing or invalid request body"),
            @ApiResponse(code=500, message = "Internal Error")})
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }
}
