package com.studentManagementSystem.controller.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentManagementSystem.dto.SubjectDTO;
import com.studentManagementSystem.model.subject.Subject;
import com.studentManagementSystem.service.subject.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public Page<Subject> getAllSubjects(Pageable pageable) {
        Page<Subject> subjects = subjectService.getAllSubjects(pageable);
        return subjects;
    }

    @GetMapping("{id}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long id) {
        SubjectDTO subjectDTO = subjectService.getSubjectById(id);
        return new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK);
    }

    @PostMapping("/upsert-subject")
    public ResponseEntity<SubjectDTO> upsertSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectDTO resultDTO = subjectService.upsertSubject(subjectDTO);
        return new ResponseEntity<>(resultDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSubjectById(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
