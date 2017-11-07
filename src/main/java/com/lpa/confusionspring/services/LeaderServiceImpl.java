package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.LeaderMapper;
import com.lpa.confusionspring.api.v1.model.LeaderDTO;
import com.lpa.confusionspring.domain.Leader;
import com.lpa.confusionspring.repositories.reactive.LeaderReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LeaderServiceImpl implements LeaderService {
    private final LeaderReactiveRepository leaderReactiveRepository;

    public LeaderServiceImpl(LeaderReactiveRepository leaderReactiveRepository) {
        this.leaderReactiveRepository = leaderReactiveRepository;
    }

    @Override
    public Flux<Leader> getLeaders() {
        return leaderReactiveRepository.findAll();
    }

    @Override
    public Flux<Leader> findByFeatured(Boolean featured) {
        return leaderReactiveRepository.findByFeatured(featured);
    }

    @Override
    public Flux<Leader> findByName(String name) {
        return leaderReactiveRepository.findByName(name);
    }

    @Override
    public Mono<Leader> findById(String id) {
        return leaderReactiveRepository.findById(id);
    }

    @Override
    public Flux<LeaderDTO> getLeadersDTO() {
        return leaderReactiveRepository
                .findAll()
                .map(leader -> LeaderMapper.INSTANCE.leaderToLeaderDTO(leader));
    }

    @Override
    public Flux<LeaderDTO> findDTOByFeatured(Boolean featured) {
        return leaderReactiveRepository
                .findByFeatured(featured)
                .map(leader -> LeaderMapper.INSTANCE.leaderToLeaderDTO(leader));
    }

    @Override
    public Flux<LeaderDTO> findDTOByName(String name) {
        return leaderReactiveRepository
                .findByName(name)
                .map(leader -> LeaderMapper.INSTANCE.leaderToLeaderDTO(leader));
    }

    @Override
    public Mono<LeaderDTO> findDTOById(String id) {
        return leaderReactiveRepository
                .findById(id)
                .map(leader -> LeaderMapper.INSTANCE.leaderToLeaderDTO(leader));
    }
}
