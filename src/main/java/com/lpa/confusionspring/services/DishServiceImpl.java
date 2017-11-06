package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.DishMapper;
import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.domain.Dish;
import com.lpa.confusionspring.repositories.reactive.DishReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DishServiceImpl implements DishService {
    private final DishReactiveRepository dishReactiveRepository;

    public DishServiceImpl(DishReactiveRepository dishReactiveRepository) {
        this.dishReactiveRepository = dishReactiveRepository;
    }

    @Override
    public Flux<Dish> getDishes() {
        return dishReactiveRepository.findAll();
    }

    @Override
    public Flux<Dish> findByFeatured(Boolean featured) {
        return dishReactiveRepository.findByFeatured(featured);
    }

    @Override
    public Flux<Dish> findByCategory(String category) {
        return dishReactiveRepository.findByCategory(category);
    }

    @Override
    public Mono<Dish> findById(String id) {
        return dishReactiveRepository.findById(id);
    }

    @Override
    public Flux<DishDTO> getDishesDTO() {
        return dishReactiveRepository
                .findAll()
                .map(dish -> DishMapper.INSTANCE.dishToDishDTO(dish));
    }

    @Override
    public Flux<DishDTO> findDTOByFeatured(Boolean featured) {
        return dishReactiveRepository
                .findByFeatured(featured)
                .map(dish -> DishMapper.INSTANCE.dishToDishDTO(dish));
    }

    @Override
    public Flux<DishDTO> findDTOByCategory(String category) {
        return dishReactiveRepository
                .findByCategory(category)
                .map(dish -> DishMapper.INSTANCE.dishToDishDTO(dish));
    }

    @Override
    public Mono<DishDTO> findDTOById(String id) {
        return dishReactiveRepository
                .findById(id)
                .map(dish -> DishMapper.INSTANCE.dishToDishDTO(dish));
    }
}
