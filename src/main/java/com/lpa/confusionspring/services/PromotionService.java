package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.model.PromotionDTO;
import com.lpa.confusionspring.domain.Promotion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PromotionService {
    Flux<Promotion> getPromotions();

    Flux<Promotion> findByFeatured(Boolean featured);

    Mono<Promotion> findById(String id);

    Flux<PromotionDTO> getPromotionsDTO();

    Flux<PromotionDTO> findDTOByFeatured(Boolean featured);

    Mono<PromotionDTO> findDTOById(String id);

}
