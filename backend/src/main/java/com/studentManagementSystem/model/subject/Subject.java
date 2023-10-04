package com.studentManagementSystem.model.subject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "subjects", uniqueConstraints = @UniqueConstraint(columnNames = {"subjectCode"}))
public class Subject {

    @Id
    @GeneratedValue(generator = "subject_generator")
    private Long id;

    @NotBlank(message = "Subject code is required!")
    private String subjectCode;

    @NotBlank(message = "Subject name is required!")
    private String subjectName;
    
}
