package com.lpa.confusionspring.controllers.v1;

import com.lpa.confusionspring.api.v1.model.PromotionDTO;
import com.lpa.confusionspring.services.PromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PromotionController.BASE_URL)
public class PromotionController {
    public static final String BASE_URL = "/promotions";

    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<PromotionDTO> getAllPromotions(
            @RequestParam(value = "featured", required = false) Boolean featured) {
        if(featured != null) {
            return promotionService.findDTOByFeatured(featured);
        }
        return promotionService.getPromotionsDTO();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PromotionDTO> getPromotion(@PathVariable String id) {
        return promotionService.findDTOById(id);
    }
}
