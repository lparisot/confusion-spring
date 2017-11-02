package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CommentReactiveRepositoryTest {
    @Autowired
    private CommentReactiveRepository commentReactiveRepository;

    @Before
    public void setUp() throws Exception {
        commentReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Comment comment = new Comment();
        comment.setAuthor("TEST");
        comment.setComment("Yummy");

        commentReactiveRepository.save(comment).block();

        Long count = commentReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

}