package com.lpa.confusionspring.domain;

import lombok.*;
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

    public Comment() {}

    public Comment(String id) {
        this.id = id;
    }
}
