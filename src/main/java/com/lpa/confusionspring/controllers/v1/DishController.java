package com.lpa.confusionspring.controllers.v1;

import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.services.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin
@RestController
@RequestMapping(DishController.BASE_URL)
public class DishController {
    public static final String BASE_URL = "/dishes";

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DishDTO> getAllDishes(
            @RequestParam(value = "featured", required = false) Boolean featured,
            @RequestParam(value = "category", required = false) String category) {
        if(featured != null) {
            return dishService.findDTOByFeatured(featured);
        }
        if(category != null) {
            return dishService.findDTOByCategory(category);
        }
        return dishService.getDishesDTO();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DishDTO> getDish(@PathVariable String id) {
        return dishService.findDTOById(id);
    }

}
