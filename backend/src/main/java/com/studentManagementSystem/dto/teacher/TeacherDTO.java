package com.studentManagementSystem.dto.teacher;

import java.util.Date;
import com.studentManagementSystem.common.dto.ModelMapper;
import com.studentManagementSystem.model.teacher.Teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO implements ModelMapper<Teacher> {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String address;
    private String phoneNumber;

    public TeacherDTO(Teacher teacher){
        this.mapToSelf(teacher);
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
        teacher.setEmail(this.getEmail());
        teacher.setDob(this.getDob());
        teacher.setAddress(this.getAddress());
        teacher.setPhoneNumber(this.getPhoneNumber());

        return teacher;
    }

    public void mapToSelf(Teacher teacher) {
        this.setId(teacher.getId());
        this.setFirstName(teacher.getFirstName());
        this.setLastName(teacher.getLastName());
        this.setEmail(teacher.getEmail());
        this.setDob(teacher.getDob());
        this.setAddress(teacher.getAddress());
        this.setPhoneNumber(teacher.getPhoneNumber());
    }
}
