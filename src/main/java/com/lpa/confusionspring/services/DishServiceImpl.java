package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.domain.Dish;
import com.lpa.confusionspring.repositories.reactive.DishReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DishServiceImpl implements DishService {
    private final DishReactiveRepository dishReactiveRepository;

    public DishServiceImpl(DishReactiveRepository dishReactiveRepository) {
        this.dishReactiveRepository = dishReactiveRepository;
    }

    @Override
    public Flux<Dish> getDishes() {
        return null;
    }

    @Override
    public Flux<Dish> findAllFeatured() {
        return null;
    }

    @Override
    public Mono<Dish> findById(String id) {
        return null;
    }
}
