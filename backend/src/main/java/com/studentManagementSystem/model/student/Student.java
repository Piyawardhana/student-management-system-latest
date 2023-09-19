package com.studentManagementSystem.model.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = {"email", "phoneNo"}))
public class Student {

    @Id
	@GeneratedValue(generator = "student_generator")
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private Long age;

	@NotBlank
	private String email;

	@NotBlank
	private String phoneNo;
	
}
