package com.studentManagementSystem.repository.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentManagementSystem.model.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
