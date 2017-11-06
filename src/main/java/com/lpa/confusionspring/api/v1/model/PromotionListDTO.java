package com.lpa.confusionspring.api.v1.model;

import com.lpa.confusionspring.domain.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionListDTO {
    List<Promotion> promotions;
}
