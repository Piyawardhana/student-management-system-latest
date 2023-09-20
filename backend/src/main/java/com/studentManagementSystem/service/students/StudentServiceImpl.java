package com.studentManagementSystem.service.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.dto.StudentDTO;
import com.studentManagementSystem.model.student.Student;
import com.studentManagementSystem.repository.student.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
	private StudentRepository studentRepository;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
		Page<Student> pageableStudents = studentRepository.findAll(pageable);
		return pageableStudents;
	}

    @Override
    public StudentDTO upsertStudent(StudentDTO studentDTO) {
        Student student = studentDTO.getModel();
        Student createStudent;

        try {
            createStudent = studentRepository.save(student);
        } catch (Exception e) {
            throw new InternalError("Failed to save student");
        }

        StudentDTO result = new StudentDTO(createStudent);
        return result;
    }
}
