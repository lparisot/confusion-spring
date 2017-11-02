package com.lpa.confusionspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Comment {
    @Id
    private String id;

    private String author;
    private Integer rating;
    private String comment;
    private String date;
}
