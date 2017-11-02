package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.CommentDTO;
import com.lpa.confusionspring.domain.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);
}
