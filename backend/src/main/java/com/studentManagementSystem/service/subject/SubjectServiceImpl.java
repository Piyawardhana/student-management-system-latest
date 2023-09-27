package com.studentManagementSystem.service.subject;

import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
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

    // @Autowired
    // private SubjectRepository subjectRepository;

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Page<Subject> getAllSubjects(Pageable pageable) {
        Page<Subject> subjects = subjectRepository.findAll(pageable);

        if(!subjects.isEmpty()){
            return subjects;
        } else{
            throw new InternalError("No subjects available");
        }
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
            if(subjectDTO.getId() == null){
                subjectRepository.save(subject);
                SubjectDTO createdSubjectDTO = new SubjectDTO(subject);
                System.out.println("Created subject");

                return createdSubjectDTO;
            } else {
                subjectRepository.save(subject);
                SubjectDTO updatedSubjectDTO = new SubjectDTO(subject);
                System.out.println("Updated subject");

                return updatedSubjectDTO;
            }
            
        } catch (Exception e) {
            throw new InternalError("Fail to save the subject because of the unique constraint of subjectCode");
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
