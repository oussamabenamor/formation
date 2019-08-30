package com.axeane.service.mapper;

import com.axeane.domain.Exam;
import com.axeane.service.dto.ExamDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExamMapper {

    @InheritInverseConfiguration
    ExamDTO fromExamToExamDto(Exam exam);

    Exam toExam(ExamDTO examDTO);

    List<ExamDTO> fromExamwToExamDtos(List<Exam> exams);
}

