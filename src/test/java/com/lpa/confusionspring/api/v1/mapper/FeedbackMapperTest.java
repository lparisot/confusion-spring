package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.FeedbackDTO;
import com.lpa.confusionspring.domain.Feedback;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeedbackMapperTest {
    private String FIRSTNAME = "John";
    private String LASTNAME = "Doe";
    private String ID = "ID";
    private FeedbackMapper feedbackMapper = FeedbackMapper.INSTANCE;

    @Test
    public void feedbackToFeedbackDTO() throws Exception {
        //given
        Feedback feedback = new Feedback();
        feedback.setId(ID);
        feedback.setFirstname(FIRSTNAME);
        feedback.setLastname(LASTNAME);

        //when
        FeedbackDTO feedbackDTO = feedbackMapper.feedbackToFeedbackDTO(feedback);

        //then
        assertEquals(ID, feedbackDTO.getId());
        assertEquals(FIRSTNAME, feedbackDTO.getFirstname());
        assertEquals(LASTNAME, feedbackDTO.getLastname());
    }

    @Test
    public void feedbackDTOToFeedback() throws Exception {
        //given
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setId(ID);
        feedbackDTO.setFirstname(FIRSTNAME);
        feedbackDTO.setLastname(LASTNAME);

        //when
        Feedback feedback = feedbackMapper.feedbackDTOToFeedback(feedbackDTO);

        //then
        assertEquals(ID, feedback.getId());
        assertEquals(FIRSTNAME, feedback.getFirstname());
        assertEquals(LASTNAME, feedback.getLastname());
    }

}