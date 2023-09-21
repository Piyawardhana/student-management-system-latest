package com.studentManagementSystem.service.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;

public interface TeacherService {

    Page<Teacher> getAllTeachers(Pageable pageable );

    String createTeacher(TeacherDTO teacherDTO);

    TeacherDTO updateTeacher(TeacherDTO teacherDTO);

    String deleteTeacher(TeacherDTO teacherDTO);

}
