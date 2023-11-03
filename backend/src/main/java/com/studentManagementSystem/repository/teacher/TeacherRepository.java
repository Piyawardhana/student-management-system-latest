package com.studentManagementSystem.repository.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentManagementSystem.model.teacher.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
}
