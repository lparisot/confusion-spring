package com.lpa.confusionspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Document
public class Dish {
    @Id
    private String id;

    private String name;
    private String image;
    private String category;
    private String label;
    private String price;
    private boolean featured;
    private String description;
    private Set<Comment> comments;

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new HashSet<>();
        }
        comments.add(comment);
    }
}
