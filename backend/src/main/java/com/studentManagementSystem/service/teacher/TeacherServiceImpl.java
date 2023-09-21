package com.studentManagementSystem.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.dto.TeacherDTO;
import com.studentManagementSystem.model.teacher.Teacher;
import com.studentManagementSystem.repository.teacher.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> getAllTeachers(Pageable pageable) {

        Page<Teacher> pageableTeachers = teacherRepository.findAll(pageable);

        return pageableTeachers;
    }

    @Override
    public String createTeacher(TeacherDTO teacherDTO) {
        
        Teacher teacher = teacherDTO.getModel();

        try {
            teacherRepository.save(teacher);
        } catch (Exception e) {
            throw new InternalError("Failed to save Teacher");
        }

        return "Successfully Inserted";

    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.getModel();

        try {
            teacherRepository.findById(teacher.getId());
        } catch (Exception e) {
            throw new InternalError("Teacher not existed with the id " + teacher.getId());
        }

        Teacher updatedTeacher = new Teacher();

        updatedTeacher.setId(teacher.getId());
        updatedTeacher.setFirstName(teacher.getFirstName());
        updatedTeacher.setLastName(teacher.getLastName());
        updatedTeacher.setAge(teacher.getAge());
        updatedTeacher.setEmail(teacher.getEmail());
        updatedTeacher.setPhoneNo(teacher.getPhoneNo());
        updatedTeacher.setDesignation(teacher.getDesignation());
        updatedTeacher.setSubjectId(teacher.getSubjectId());

        TeacherDTO updatedTeacherDTO = new TeacherDTO(teacherRepository.save(updatedTeacher));

        return updatedTeacherDTO;

    }

    @Override
    public String deleteTeacher(TeacherDTO teacherDTO) {
        
        Teacher teacher = teacherDTO.getModel();

        try {
            teacherRepository.findById(teacher.getId());
            teacherRepository.deleteById(teacher.getId());
        } catch (Exception e) {
            throw new InternalError("Teacher not existed with the id " + teacher.getId());
        }

        return "Deleted Successfully";

    }
    
}
