package com.studentManagementSystem.service.teacher;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.studentManagementSystem.dto.teacher.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.repository.teacher.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    
    @Override
    public Page<Teacher> getTeacher(Pageable pageable){
        Page<Teacher> teachers = teacherRepository.findAll(pageable);
        return teachers;
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        Teacher teacher = optionalTeacher.get();
        TeacherDTO teacherDto = new TeacherDTO(teacher);
        
        return teacherDto;
    }

    @Override
    public TeacherDTO upsertTeacher(TeacherDTO teacherDTO){
        Teacher createdTeacher = teacherDTO.getModel();
        teacherRepository.save(createdTeacher);
        TeacherDTO createdTeacherDto = new TeacherDTO(createdTeacher);

        return createdTeacherDto;    
    }

    @Override
    public ResponseEntity<HttpStatus> deleteTeacher(Long id){
        try {
            teacherRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            throw new IllegalArgumentException(String.format("No records found with given ID: %s!", id));
        }
    }
}
