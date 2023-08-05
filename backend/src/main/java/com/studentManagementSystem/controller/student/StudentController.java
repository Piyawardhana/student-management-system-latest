package com.studentManagementSystem.controller.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagementSystem.model.student.Student;
import com.studentManagementSystem.repository.student.StudentRepository;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
	private StudentRepository studentRepository;

	// get all students

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@PostMapping("/students")
	public String createStudent(@RequestBody Student std) {
		studentRepository.save(std);
		return "Successfully Inserted";
	}
    
}
