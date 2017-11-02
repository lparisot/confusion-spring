package com.lpa.confusionspring.repositories;

import com.lpa.confusionspring.domain.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, String> {
}
