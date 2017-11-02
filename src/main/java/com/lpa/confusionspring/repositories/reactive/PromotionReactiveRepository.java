package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Promotion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PromotionReactiveRepository extends ReactiveMongoRepository<Promotion, String> {
    Flux<Promotion> findByFeatured(boolean featured);
}
