package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Dish;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DishReactiveRepository extends ReactiveMongoRepository<Dish, String> {
    Mono<Dish> findByName(String name);

    Flux<Dish> findByFeatured(boolean featured);

    Flux<Dish> findByCategory(String category);
}
