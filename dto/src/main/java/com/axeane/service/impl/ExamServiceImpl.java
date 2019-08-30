package com.axeane.service.impl;

import com.axeane.domain.Exam;
import com.axeane.repository.ExamRepository;
import com.axeane.service.ExamService;
import com.axeane.service.dto.ExamDTO;
import com.axeane.service.mapper.ExamMapper;
import com.axeane.web.errors.BadRequestError;
import com.axeane.web.errors.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    private final ExamRepository examRepository;

    private final ExamMapper examMapper;
    private static final Logger logger = LogManager.getLogger(ExamServiceImpl.class);


    public ExamServiceImpl(ExamRepository examRepository, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
    }



    @Transactional
    public List<ExamDTO> getExams() {
        List<Exam> exams = this.examRepository.findAll();
        this.logger.info(exams);
        List<ExamDTO> examDTOS = new ArrayList<>();
        exams.forEach( e -> {
            examDTOS.add(this.examMapper.fromExamToExamDto(e));
        });
        return examDTOS;
    }

    public ExamDTO newExam(ExamDTO examDTO) {
        if (examDTO.getId()!=null) {

            throw new BadRequestError();
        }
        Exam exam = this.examMapper.toExam(examDTO);


        examRepository.save(exam);
        return examDTO;
    }

    public void editExam(ExamDTO examDTO) {
        if (examDTO.getId() == null) {
            logger.fatal("Damn! Fatal error. Please fix me.");
            throw new BadRequestError();
        }

        Optional<Exam> examToUpdate = examRepository.findById(examDTO.getId());
        if (!examToUpdate.isPresent()) {
            throw new ResourceNotFound();
        } else {
            examToUpdate.get().setTitle(examDTO.getTitle());
            examToUpdate.get().setDescription(examDTO.getDescription());
            examToUpdate.get().setPublished(examDTO.isPublished());

            examRepository.save(examToUpdate.get());

        }
    }

    @Override
    public Exam findbyid(long id) {
  return examRepository.findById(id).get();
    }
}
