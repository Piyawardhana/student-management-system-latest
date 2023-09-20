package com.studentManagementSystem.dto;

import com.studentManagementSystem.common.dto.ModelMapper;
import com.studentManagementSystem.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements ModelMapper<Student> {
    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String phoneNo;

    public StudentDTO(Student student) {
        this.mapToSelf(student);
    }

    @Override
    public Student getModel() {
        Student student = new Student();
        mapToModel(student);
        return student;
    }

    @Override
    public Student mapToModel(Student student) {
        student.setId(this.getId());
        student.setFirstName(this.getFirstName());
        student.setLastName(this.getLastName());
        student.setAge(this.getAge());
        student.setEmail(this.getEmail());
        student.setPhoneNo(this.getPhoneNo());

        return student;
    }

    @Override
    public void mapToSelf(Student student) {
        this.setId(student.getId());
        this.setFirstName(student.getFirstName());
        this.setLastName(student.getLastName());
        this.setAge(student.getAge());
        this.setEmail(student.getEmail());
        this.setPhoneNo(student.getPhoneNo());
    }

}
