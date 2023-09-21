package com.studentManagementSystem.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.service.teacher.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public Page<Teacher> getAllTeachers(Pageable pageable){

        Page<Teacher> pageableTeachers = teacherService.getAllTeachers(pageable);

        return pageableTeachers;

    }

    @PostMapping("/create-teacher")
    public String createTeacher(@RequestBody TeacherDTO teacherDTO){

        String message = teacherService.createTeacher(teacherDTO);
        return message;

    }

    @PutMapping("/update-teacher")
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO){
        
        return ResponseEntity.ok(teacherService.updateTeacher(teacherDTO));

    }

    @DeleteMapping("/delete-teacher")
    public String deleteTEacher(@RequestBody TeacherDTO teacherDTO){
        
        String message = teacherService.deleteTeacher(teacherDTO);

        return message;

    }
    
}
