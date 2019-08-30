package com.axeane.repository;

import com.axeane.domain.Exam;
import com.axeane.service.ExamService;
import com.axeane.service.dto.ExamDTO;
import com.axeane.service.mapper.ExamMapper;
import com.axeane.web.errors.BadRequestError;
import com.axeane.web.errors.ResourceNotFound;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest()
public class ExamRepositoryTest {

    @Autowired
    private ExamService examService;
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamMapper examMapper;

    private static String TITLE = "Foo";
    private static final String DESCRIPTION = "Foo";
    private static final Boolean PUBLISHED = false;
    private ExamDTO examDTO;

    private ExamDTO createexamEntity() {
        ExamDTO examDTO = new ExamDTO();

        examDTO.setTitle(TITLE);
        examDTO.setDescription(DESCRIPTION);
        examDTO.setPublished(PUBLISHED);
        return examDTO;
    }
    @Before
    public void setUp() {

        examDTO = createexamEntity();
    }

    @Test
    @Transactional
    public void getAllPostsByUserId() {
        boolean isException;
        try {
            ExamDTO savedExamDto = examService.newExam(examDTO);


            isException = false;
        } catch (ResourceNotFound e) {
            isException = true;
        }
        assertThat(isException).isFalse();
    }




    @Test
    public void testFindByName() {
        ExamDTO dto = new ExamDTO("Foo", "Foo", false);
        Exam examToSave = examRepository.save(examMapper.toExam(dto));
        Optional<Exam> client = examRepository.findById(examToSave.getId());
        assertEquals("Foo", client.get().getTitle());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();




    @Test
    public void updateExam() {
        boolean isException;
        try {
            ExamDTO exam = examService.newExam(examDTO);


            examService.editExam(exam);
            isException = false;
        } catch (BadRequestError e) {
            isException = true;
        }
        assertThat(isException).isFalse();
    }



}