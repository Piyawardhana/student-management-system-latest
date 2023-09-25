package com.studentManagementSystem.service.subject;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();

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
            throw new InternalError("No record is available with " + id + " id");
        }
    }

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = subjectDTO.getModel();

        try {
            subjectRepository.save(subject);
            SubjectDTO createdSubjectDTO = new SubjectDTO(subject);

            return createdSubjectDTO;
        } catch (Exception e) {
            throw new InternalError("Fail to save the subject");
        }
    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        Subject subject = subjectDTO.getModel();

        try {
            subjectRepository.save(subject);
            SubjectDTO updatedSubjectDTO = new SubjectDTO(subject);

            return updatedSubjectDTO;
        } catch (Exception e) {
            throw new InternalError("There is no subject existed with " + subject.getId() + " id");
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
