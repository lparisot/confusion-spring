package com.lpa.confusionspring.repositories;

import com.lpa.confusionspring.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {
}
