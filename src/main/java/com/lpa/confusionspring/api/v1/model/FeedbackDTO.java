package com.lpa.confusionspring.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    private String id;

    private String firstname;
    private String lastname;
    private Integer telnum;
    private String email;
    private boolean agree;
    private String contacttype;
    private String message;
}
