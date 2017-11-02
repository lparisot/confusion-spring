package com.lpa.confusionspring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {
    private String id;

    private String name;
    private String image;
    private String label;
    private String price;
    private boolean featured;
    private String description;
}
