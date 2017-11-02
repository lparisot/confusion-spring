package com.lpa.confusionspring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Promotion {
    @Id
    private String id;

    private String name;
    private String image;
    private String label;
    private String price;
    private boolean featured;
    private String description;
}
