package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.domain.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DishService {
    Flux<Dish> getDishes();

    Flux<Dish> findByFeatured(Boolean featured);

    Flux<Dish> findByCategory(String category);

    Mono<Dish> findById(String id);

    Flux<DishDTO> getDishesDTO();

    Flux<DishDTO> findDTOByFeatured(Boolean featured);

    Flux<DishDTO> findDTOByCategory(String category);

    Mono<DishDTO> findDTOById(String id);
}
