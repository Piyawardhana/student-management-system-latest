package com.studentManagementSystem.dto;

import com.studentManagementSystem.common.dto.ModelMapper;
import com.studentManagementSystem.model.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO implements ModelMapper<Subject> {

    private Long id;
    private String subjectCode;
    private String subjectName;

    public SubjectDTO(Subject subject){
        this.mapToSelf(subject);
    }

    @Override
    public Subject getModel() {
        Subject subject = new Subject();
        this.mapToModel(subject);

        return subject;
    }

    @Override
    public Subject mapToModel(Subject subject) {
        subject.setId(this.getId());
        subject.setSubjectCode(this.getSubjectCode());
        subject.setSubjectName(this.getSubjectName());

        return subject;
    }

    @Override
    public void mapToSelf(Subject subject) {
        this.setId(subject.getId());
        this.setSubjectCode(subject.getSubjectCode());
        this.setSubjectName(subject.getSubjectName());
    }
    
}
