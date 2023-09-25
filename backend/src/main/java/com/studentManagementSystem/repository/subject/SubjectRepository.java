package com.studentManagementSystem.repository.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentManagementSystem.model.subject.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
