package com.SpringBoot_restapi.controller;


import com.SpringBoot_restapi.exception.ResourcesNotFoundExecption;
import com.SpringBoot_restapi.model.Student;
import com.SpringBoot_restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.findAll();

    }

    //build create student REST API
    @PostMapping
    public Student createstudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //build get student by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExecption("Student not exist with id:" + id));
        return ResponseEntity.ok(student);

    }
    //build update student REST API
    @PutMapping("{id}")
    public  ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExecption("Student not exist with id: " +id));

        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    //build delete student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExecption("Student not exist with id: " +id));
        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);



    }


}

