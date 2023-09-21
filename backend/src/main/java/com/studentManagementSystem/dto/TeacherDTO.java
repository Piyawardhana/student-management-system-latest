package com.studentManagementSystem.dto;

import com.studentManagementSystem.common.dto.ModelMapper;
import com.studentManagementSystem.model.teacher.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO implements ModelMapper<Teacher>{

    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String phoneNo;
    private String designation;
    private Long subjectId;

    public TeacherDTO(Teacher tacher){
        this.mapToSelf(tacher);
    }

    @Override
    public Teacher getModel() {
        
        Teacher teacher = new Teacher();
        mapToModel(teacher);

        return teacher;
        
    }

    @Override
    public Teacher mapToModel(Teacher teacher) {
        
        teacher.setId(this.getId());
        teacher.setFirstName(this.getFirstName());
        teacher.setLastName(this.getLastName());
        teacher.setAge(this.getAge());
        teacher.setEmail(this.getEmail());
        teacher.setPhoneNo(this.getPhoneNo());
        teacher.setDesignation(this.getDesignation());
        teacher.setSubjectId(this.getSubjectId());

        return teacher;

    }

    @Override
    public void mapToSelf(Teacher teacher) {
        
        this.setId(teacher.getId());
        this.setFirstName(teacher.getFirstName());
        this.setLastName(teacher.getLastName());
        this.setAge(teacher.getAge());
        this.setEmail(teacher.getEmail());
        this.setPhoneNo(teacher.getPhoneNo());
        this.setDesignation(teacher.getDesignation());
        this.setSubjectId(teacher.getSubjectId());

    }

    
    
}
