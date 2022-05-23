package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/insertStudentDetails")
    public Student createNewStudentRecord(@RequestBody Student student){
        System.out.println("--- student details "+student.toString());
        return studentService.storeStudentDetails(student);
    }

    @GetMapping("/viewAllStudentDetails")
    public List<Student> getAllStudents(){
        return studentService.getAllStudentRecords();
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudentDetails(@PathVariable("id") int studentId, Student student){
//        System.out.println("--- student details "+student.toString());
        return studentService.updateStudentRecord(studentId,student);
    }

    @DeleteMapping("/deleteStudentDetails/{id}")
    public String deleteStudentDetails(@PathVariable("id") int studentId){
        return studentService.deleteStudentDetails(studentId);
    }
}
