package com.studentManagementSystem.service.subject;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.studentManagementSystem.dto.SubjectDTO;
import com.studentManagementSystem.model.subject.Subject;
import com.studentManagementSystem.repository.subject.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

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
            throw new InternalError("No subject is available with " + id + " id");
        }
    }

    @Override
    public SubjectDTO upsertSubject(SubjectDTO subjectDTO) {
        Subject subject = subjectDTO.getModel();

        try {
            subjectRepository.save(subject);
            SubjectDTO resultDTO = new SubjectDTO(subject);
            return resultDTO;

        } catch (Exception e) {
            throw new InternalError("Fail to save the subject.");
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSubjectById(Long id) {
        try {
            subjectRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new InternalError("There is no subject existed with " + id + " id");
        }
    }
}
