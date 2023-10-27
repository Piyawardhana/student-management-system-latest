package com.studentManagementSystem.service.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;

public interface TeacherService {

    Page<Teacher> getAllTeachers(Pageable pageable );

    TeacherDTO getTeacherById(Long id);

    TeacherDTO createTeacher(TeacherDTO teacherDTO);

    TeacherDTO updateTeacher(TeacherDTO teacherDTO);

    ResponseEntity<HttpStatus> deleteById(Long id);

}
