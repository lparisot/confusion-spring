package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.CommentDTO;
import com.lpa.confusionspring.domain.Comment;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentMapperTest {
    private String AUTHOR = "Doe";
    private String ID = "ID";
    private CommentMapper commentMapper = CommentMapper.INSTANCE;

    @Test
    public void commentToCommentDTO() throws Exception {
        //given
        Comment comment = new Comment();
        comment.setId(ID);
        comment.setAuthor(AUTHOR);

        //when
        CommentDTO commentDTO = commentMapper.commentToCommentDTO(comment);

        //then
        assertEquals(ID, commentDTO.getId());
        assertEquals(AUTHOR, commentDTO.getAuthor());
    }

    @Test
    public void commentDTOToComment() throws Exception {
        //given
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(ID);
        commentDTO.setAuthor(AUTHOR);

        //when
        Comment comment = commentMapper.commentDTOToComment(commentDTO);

        //then
        assertEquals(ID, comment.getId());
        assertEquals(AUTHOR, comment.getAuthor());
    }

}