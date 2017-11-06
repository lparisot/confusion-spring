package com.lpa.confusionspring.api.v1.model;

import com.lpa.confusionspring.domain.Leader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderListDTO {
    List<Leader> leaders;
}
