package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Feedback;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FeedbackReactiveRepository extends ReactiveMongoRepository<Feedback, String> {
}
