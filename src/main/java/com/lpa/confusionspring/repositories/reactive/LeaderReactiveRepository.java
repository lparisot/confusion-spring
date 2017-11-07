package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Leader;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LeaderReactiveRepository extends ReactiveMongoRepository<Leader, String> {
    Flux<Leader> findByFeatured(boolean featured);

    Flux<Leader> findByName(String name);
}
