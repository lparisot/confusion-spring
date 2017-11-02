package com.lpa.confusionspring.services;

import com.lpa.confusionspring.domain.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DishService {
    Flux<Dish> getDishes();

    Flux<Dish> findAllFeatured();

    Mono<Dish> findById(String id);
}
