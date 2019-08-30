package com.axeane.service;

import com.axeane.domain.Exam;
import com.axeane.service.dto.ExamDTO;

import java.util.List;

public interface ExamService {
    List<ExamDTO> getExams();

    ExamDTO newExam(ExamDTO exam);

    void editExam(ExamDTO examDTO);

    Exam findbyid(long id);

}
