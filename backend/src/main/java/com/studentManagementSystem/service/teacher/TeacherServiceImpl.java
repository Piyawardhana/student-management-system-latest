package com.studentManagementSystem.service.teacher;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.repository.teacher.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> getAllTeachers(Pageable pageable) {
        Page<Teacher> pageableTeachers = teacherRepository.findAll(pageable);
        return pageableTeachers;
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        try {
            Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
            Teacher teacher = optionalTeacher.get();
            TeacherDTO teacherDTO = new TeacherDTO(teacher);

            return teacherDTO;
        } catch (Exception e) {
            throw new InternalError("Teacher not existed with the id " + id);
        }
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {  
        Teacher teacher = teacherDTO.getModel();

        try {
            teacherRepository.save(teacher);
            TeacherDTO savedTeacherDTO = new TeacherDTO(teacher);
            
            return savedTeacherDTO;
        } catch (Exception e) {
            throw new InternalError("Failed to save Teacher");
        }
    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.getModel();

        try {
            Teacher updatedTeacher = teacherRepository.save(teacher);
            TeacherDTO updatedTeacherDTO = new TeacherDTO(updatedTeacher);

            return updatedTeacherDTO;
        } catch (Exception e) {
            throw new InternalError("Teacher not existed with the id " + teacher.getId());
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {
        try {
            teacherRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new InternalError("Teacher not existed with the id " + id);
        }
    }
}
