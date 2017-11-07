package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.PromotionMapper;
import com.lpa.confusionspring.api.v1.model.PromotionDTO;
import com.lpa.confusionspring.domain.Promotion;
import com.lpa.confusionspring.repositories.reactive.PromotionReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PromotionServiceImpl implements PromotionService {
    private PromotionReactiveRepository promotionReactiveRepository;

    public PromotionServiceImpl(PromotionReactiveRepository promotionReactiveRepository) {
        this.promotionReactiveRepository = promotionReactiveRepository;
    }

    @Override
    public Flux<Promotion> getPromotions() {
        return promotionReactiveRepository.findAll();
    }

    @Override
    public Flux<Promotion> findByFeatured(Boolean featured) {
        return promotionReactiveRepository.findByFeatured(featured);
    }

    @Override
    public Mono<Promotion> findById(String id) {
        return promotionReactiveRepository.findById(id);
    }

    @Override
    public Flux<PromotionDTO> getPromotionsDTO() {
        return promotionReactiveRepository
                .findAll()
                .map(promotion -> PromotionMapper.INSTANCE.promotionToPromotionDTO(promotion));
    }

    @Override
    public Flux<PromotionDTO> findDTOByFeatured(Boolean featured) {
        return promotionReactiveRepository
                .findByFeatured(featured)
                .map(promotion -> PromotionMapper.INSTANCE.promotionToPromotionDTO(promotion));
    }

    @Override
    public Mono<PromotionDTO> findDTOById(String id) {
        return promotionReactiveRepository
                .findById(id)
                .map(promotion -> PromotionMapper.INSTANCE.promotionToPromotionDTO(promotion));
    }
}
