package com.lpa.confusionspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Feedback {
    @Id
    private String id;

    private String firstname;
    private String lastname;
    private Integer telnum;
    private String email;
    private boolean agree;
    private String contacttype;
    private String message;

    public Feedback() {}

    public Feedback(String id) {
        this.id = id;
    }
}
