package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommentReactiveRepository extends ReactiveMongoRepository<Comment, String> {
}
