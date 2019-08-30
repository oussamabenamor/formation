//package com.axeane.model;
//
//
//import com.axeane.domain.Exam;
//import com.axeane.service.dto.ExamDTO;
//import org.modelmapper.ModelMapper;
//
//import static org.junit.Assert.assertEquals;
//public class ExamUT {
//
//    private static final ModelMapper modelMapper = new ModelMapper();
//
//    @Test
//    public void checkExamMapping() {
//        ExamDTO creation = new ExamDTO();
//        creation.setTitle("Testing title");
//        creation.setDescription("Testing description");
//
//        Exam exam = modelMapper.map(creation, Exam.class);
//        assertEquals(creation.getTitle(), exam.getTitle());
//        assertEquals(creation.getDescription(), exam.getDescription());
//
//
//        ExamDTO update = new ExamDTO();
//        update.setTitle("New title");
//        update.setDescription("New description");
//
//        modelMapper.map(update, exam);
//        assertEquals(update.getTitle(), exam.getTitle());
//        assertEquals(update.getDescription(), exam.getDescription());
//
//    }
//}
