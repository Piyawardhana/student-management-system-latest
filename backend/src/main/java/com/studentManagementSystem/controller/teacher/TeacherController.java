package com.studentManagementSystem.controller.teacher;
import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.service.teacher.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id){
        TeacherDTO teacherDTO = teacherService.getTeacherById(id);

        return new ResponseEntity<TeacherDTO>(teacherDTO, HttpStatus.OK);
    }

    @PostMapping("/create-teacher")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO createdTeacherDTO = teacherService.createTeacher(teacherDTO);

        return new ResponseEntity<TeacherDTO>(createdTeacherDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update-teacher")
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO updatedTeacherDTO = teacherService.updateTeacher(teacherDTO);

        return new ResponseEntity<TeacherDTO>(updatedTeacherDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTEacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);

        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
    
}
