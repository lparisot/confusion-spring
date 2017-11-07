package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.DishMapper;
import com.lpa.confusionspring.domain.Dish;
import com.lpa.confusionspring.repositories.reactive.DishReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DishServiceTest {
    private DishService dishService;

    @Mock
    private DishReactiveRepository dishReactiveRepository;

    private DishMapper dishMapper = DishMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
        // tell mockito to give me a mock recipe repository
        MockitoAnnotations.initMocks(this);

        dishService = new DishServiceImpl(dishReactiveRepository);
    }

    @Test
    public void getDishes() throws Exception {
        Dish dish = new Dish();

        when(dishService.getDishes()).thenReturn(Flux.just(dish));

        List<Dish> dishes = dishService.getDishes().collectList().block();

        assertEquals(1, dishes.size());
        verify(dishReactiveRepository, times(1)).findAll();
    }

    @Test
    public void findAllFeatured() throws Exception {
        Dish dish1 = new Dish();
        dish1.setFeatured(true);
        Dish dish2 = new Dish();
        dish2.setFeatured(true);

        when(dishService.findByFeatured(anyBoolean())).thenReturn(Flux.fromIterable(Arrays.asList(dish1, dish2)));

        List<Dish> dishes = dishService.findByFeatured(true).collectList().block();

        assertEquals(2, dishes.size());
    }

    @Test
    public void findDishById() throws Exception {
        Dish dish = new Dish();
        dish.setId("1");

        when(dishReactiveRepository.findById(anyString())).thenReturn(Mono.just(dish));

        Dish dishReturned = dishService.findById("1").block();

        assertNotNull("Null recipe returned", dishReturned);
        verify(dishReactiveRepository, times(1)).findById(anyString());
        verify(dishReactiveRepository, never()).findAll();
    }

    @Test
    public void findByCategory() throws Exception {
        Dish dish = new Dish();
        dish.setId("1");
        dish.setCategory("Test");

        when(dishReactiveRepository.findByCategory(anyString())).thenReturn(Flux.just(dish));

        List<Dish> dishes = dishService.findByCategory("Test").collectList().block();

        assertEquals(1, dishes.size());
        assertEquals("Test", dishes.get(0).getCategory());
        verify(dishReactiveRepository, times(1)).findByCategory(anyString());
        verify(dishReactiveRepository, never()).findAll();
    }
}