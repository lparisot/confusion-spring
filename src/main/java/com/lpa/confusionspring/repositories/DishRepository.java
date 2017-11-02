package com.lpa.confusionspring.repositories;

import com.lpa.confusionspring.domain.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, String> {
    Optional<Dish> findByName(String name);
}
