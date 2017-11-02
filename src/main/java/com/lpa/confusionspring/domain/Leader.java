package com.lpa.confusionspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Leader {
    @Id
    private String id;

    private String name;
    private String image;
    private String designation;
    private String abbr;
    private boolean featured;
    private String description;
}
