package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.model.LeaderDTO;
import com.lpa.confusionspring.domain.Leader;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LeaderService {
    Flux<Leader> getLeaders();

    Flux<Leader> findByFeatured(Boolean featured);

    Flux<Leader> findByName(String name);

    Mono<Leader> findById(String id);

    Flux<LeaderDTO> getLeadersDTO();

    Flux<LeaderDTO> findDTOByFeatured(Boolean featured);

    Flux<LeaderDTO> findDTOByName(String name);

    Mono<LeaderDTO> findDTOById(String id);

}
