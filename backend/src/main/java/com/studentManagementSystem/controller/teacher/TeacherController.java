package com.studentManagementSystem.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentManagementSystem.dto.teacher.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.service.teacher.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Page<Teacher> getTeacher(Pageable pageable) {
        Page<Teacher> pageableTeachers = teacherService.getTeacher(pageable);
        return pageableTeachers;
    }
    
    @GetMapping("{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);
        return teacherDTO;
    }

    @PostMapping("/upsert-teacher")
    public ResponseEntity<TeacherDTO> upsertTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO upsertTeacherDto = teacherService.upsertTeacher(teacherDTO);
        return new ResponseEntity<>(upsertTeacherDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

}
