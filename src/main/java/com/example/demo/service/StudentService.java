package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //to insert student details into db
    public Student storeStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    //To view all student records from db
    public List<Student> getAllStudentRecords(){
        return studentRepository.findAll();
    }

    //to update existing student record
    public String updateStudentRecord(int studentId, Student student){

        String response = "";
        Optional<Student> studentDetails = studentRepository.findById(studentId);
        if(studentDetails.isEmpty()){
            response = "Student record not found with provided id "+studentId+"\n Please insert record first to update";
            return response;
        }

        Student updateStudent = studentDetails.get();
        updateStudent.setName(student.getName());
        updateStudent.setPassYear(student.getPassYear());
        updateStudent.setRollNo(student.getRollNo());
        updateStudent.setMark(student.getMark());

        studentRepository.save(updateStudent);
        return updateStudent.toString();
    }

    //to delete a particular student
    public String deleteStudentDetails(int studentId){
        String response = "";
        Optional<Student> studentDetails = studentRepository.findById(studentId);
        if(studentDetails.isEmpty()){
            response = "Student record not found with provided id "+studentId+"\n Please insert record first to delete";
            return response;
        }

        response = "Student details \n"+studentDetails.get()+", deleted successfully";
        studentRepository.deleteById(studentId);
        return response;
    }
}
