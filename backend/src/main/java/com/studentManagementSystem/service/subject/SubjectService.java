package com.studentManagementSystem.service.subject;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentManagementSystem.dto.SubjectDTO;
import com.studentManagementSystem.model.subject.Subject;

public interface SubjectService {

    List<Subject> getAllSubjects();

    SubjectDTO getSubjectById(Long id);

    SubjectDTO createSubject(SubjectDTO subjectDTO);

    SubjectDTO updateSubject(SubjectDTO subjectDTO);

    ResponseEntity<HttpStatus> deleteSubjectById(Long id);
    
}
