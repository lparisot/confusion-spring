package com.lpa.confusionspring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String id;

    private String author;
    private Integer rating;
    private String comment;
    private String date;
}
