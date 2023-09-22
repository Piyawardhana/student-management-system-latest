package com.studentManagementSystem.model.teacher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "teachers", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "phoneNo"}))
public class Teacher {

    @Id
    @GeneratedValue(generator = "teacher_generator")
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Long age;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNo;

    @NotBlank
    private String designation;

    @NotNull
    private Long subjectId;
    
}

