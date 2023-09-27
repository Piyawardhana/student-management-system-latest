package com.studentManagementSystem.service.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentManagementSystem.dto.SubjectDTO;
import com.studentManagementSystem.model.subject.Subject;

public interface SubjectService {

    Page<Subject> getAllSubjects(Pageable pageable);

    SubjectDTO getSubjectById(Long id);

    SubjectDTO upsertSubject(SubjectDTO subjectDTO);

    ResponseEntity<HttpStatus> deleteSubjectById(Long id);
    
}
