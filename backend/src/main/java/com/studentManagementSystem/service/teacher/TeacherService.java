package com.studentManagementSystem.service.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentManagementSystem.dto.teacher.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;

public interface TeacherService {
    Page<Teacher> getTeacher(Pageable pageable);

    TeacherDTO getTeacherById(Long id);

    TeacherDTO upsertTeacher(TeacherDTO teacherDTO);

    ResponseEntity<HttpStatus> deleteTeacher(Long id);
}
