package com.studentManagementSystem.service.students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.studentManagementSystem.dto.StudentDTO;
import com.studentManagementSystem.model.student.Student;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);

    StudentDTO upsertStudent(StudentDTO studentDTO);
}
