package com.lpa.confusionspring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String id;

    private String name;
    private String image;
    private String category;
    private String label;
    private String price;
    private boolean featured;
    private String description;
    private Set<CommentDTO> comments;
}
