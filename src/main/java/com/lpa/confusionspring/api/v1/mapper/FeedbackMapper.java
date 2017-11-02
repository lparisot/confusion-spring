package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.FeedbackDTO;
import com.lpa.confusionspring.domain.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackMapper INSTANCE = Mappers.getMapper(FeedbackMapper.class);

    FeedbackDTO feedbackToFeedbackDTO(Feedback feedback);

    Feedback feedbackDTOToFeedback(FeedbackDTO feedbackDTO);
}
