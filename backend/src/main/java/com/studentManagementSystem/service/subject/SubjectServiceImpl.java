package com.studentManagementSystem.service.subject;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.studentManagementSystem.common.utility.StringUtils;
import com.studentManagementSystem.dto.SubjectDTO;
import com.studentManagementSystem.model.subject.Subject;
import com.studentManagementSystem.repository.subject.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

    Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Autowired
    private SubjectRepository subjectRepository;

    // private final SubjectRepository subjectRepository;

    // public SubjectServiceImpl(SubjectRepository subjectRepository) {
    //     this.subjectRepository = subjectRepository;
    // }

    @Override
    public Page<Subject> getAllSubjects(Pageable pageable) {
        Page<Subject> subjects = subjectRepository.findAll(pageable);
        return subjects;
    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(id);
            Subject subject = optionalSubject.get();
            SubjectDTO subjectDTO = new SubjectDTO(subject);

            return subjectDTO;
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("No subject is available with ID:%s!", id));

        }
    }

    @Override
    public SubjectDTO upsertSubject(SubjectDTO subjectDTO) {

        if (StringUtils.isBlank(subjectDTO.getSubjectCode())) {
            throw new IllegalArgumentException("Subject code is required!");
        }

        if (StringUtils.isBlank(subjectDTO.getSubjectName())) {
            throw new IllegalArgumentException("Subject name is required!");
        }

        Subject subject = subjectDTO.getModel();

        try {
            subjectRepository.save(subject);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Subject with the given subject code already exists!");
        }

        SubjectDTO resultDTO = new SubjectDTO(subject);
        return resultDTO;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSubjectById(Long id) {
        try {
            subjectRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
             throw new IllegalArgumentException(String.format("No subject is available with ID:%s!", id));
        }
    }
}
