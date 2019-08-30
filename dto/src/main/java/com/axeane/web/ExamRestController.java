package com.axeane.web;

import com.axeane.domain.Exam;
import com.axeane.service.ExamService;
import com.axeane.service.dto.ExamDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exams")
public class ExamRestController {

    private final ExamService examService;

    public ExamRestController(ExamService examService) {
        this.examService = examService;
    }

    //    @ApiOperation(value = "returns all the exams")
    @GetMapping("/test")
    public ResponseEntity getExams() {
        return new ResponseEntity<>(examService.getExams(), HttpStatus.OK);
    }


    @ApiOperation(value = "adds an exam")
    @PostMapping
    public void newExam(@RequestBody @Valid ExamDTO examDTO) {
        examService.newExam(examDTO);
    }

    @ApiOperation(value = " updates an exam")
    @PutMapping
//    @ResponseStatus(HttpStatus.OK)
    public void editExam(@RequestBody @Valid ExamDTO examDTO) {
        examService.editExam(examDTO);
    }


    @ApiOperation(value = " updates an exam")
    @GetMapping("/test/{id}")
    public Exam editExam(@PathVariable Long id) {
      return examService.findbyid(id);
    }
}