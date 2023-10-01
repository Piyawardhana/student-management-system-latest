package com.studentManagementSystem.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentManagementSystem.dto.StudentDTO;
import com.studentManagementSystem.model.student.Student;
import com.studentManagementSystem.service.students.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
	private StudentService studentService;

	// @ApiOperation(value = "Get all students", response = Student.class)
	@GetMapping
    public Page<Student> getAllStudents(Pageable pageable) {
		Page<Student> pageableStudents = studentService.getAllStudents(pageable);
		return pageableStudents;
	}

	// @ApiOperation(value = "Get all students", response = StudentDTO.class)
	@PostMapping("/create-student")
	public ResponseEntity<StudentDTO> upsertStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO savedStudent = studentService.upsertStudent(studentDTO);
		return new ResponseEntity<StudentDTO>(savedStudent, HttpStatus.CREATED);
	}
}
