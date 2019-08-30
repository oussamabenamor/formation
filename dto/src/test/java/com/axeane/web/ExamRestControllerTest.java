package com.axeane.web;


import com.axeane.service.ExamService;
import com.axeane.service.dto.ExamDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ExamRestControllerTest {

    @Autowired

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ExamRestController examRestController;

    @Autowired
    private ExamService examService;

    private static String TITLE = "ok";
    private static final String DESCRIPTION = "ok";
    private static final Boolean PUBLISHED = true;
    private ExamDTO examDTO;

    private ExamDTO createexamEntity() {
        ExamDTO examDTO = new ExamDTO();

        examDTO.setTitle(TITLE);
        examDTO.setDescription(DESCRIPTION);
        examDTO.setPublished(PUBLISHED);
        return examDTO;
    }

    @Before
    public void initTest() {
        examDTO = createexamEntity();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(examRestController).build();
    }

    @Test
    public void getAllEmployeesAPI() throws Exception {
        this.examService.newExam(examDTO);
         mockMvc.perform(get("/exams/test")
                .contentType(MediaType.APPLICATION_JSON))
                 .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createEmployeeAPI() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/exams")
                .content(asJsonString(new ExamDTO( "oui", "oui", false)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void updateexam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/exams/")
                .content(asJsonString(new ExamDTO(100L, "non", "non", false)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); }
    @Test
    public void getexamById() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/exams/test/{id}",100)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}