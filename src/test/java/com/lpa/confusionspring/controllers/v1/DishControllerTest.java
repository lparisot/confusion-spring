package com.lpa.confusionspring.controllers.v1;

import com.lpa.confusionspring.domain.Dish;
import com.lpa.confusionspring.services.DishService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
public class DishControllerTest {
    @Mock
    private DishService dishService;
    @InjectMocks
    private DishController dishController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(dishController)
                .build();
    }

    @Test
    public void getAllDishes() throws Exception {
        Dish dish1 = new Dish();
        dish1.setName("dish1");

        Dish dish2 = new Dish();
        dish2.setName("dish2");

        List<Dish> dishes = Arrays.asList(dish1, dish2);

        when(dishService.getDishes()).thenReturn(Flux.fromIterable(dishes));

        mockMvc.perform(get(DishController.BASE_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getFeatured() throws Exception {
        Dish dish1 = new Dish();
        dish1.setName("dish1");
        dish1.setFeatured(true);

        Dish dish2 = new Dish();
        dish2.setName("dish2");
        dish2.setFeatured(true);

        List<Dish> dishes = Arrays.asList(dish1, dish2);

        when(dishService.findByFeatured(anyBoolean())).thenReturn(Flux.fromIterable(dishes));

        mockMvc.perform(get(DishController.BASE_URL + "/?featured=true").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getDish() throws Exception {
        Dish dish = new Dish();
        dish.setName("dish1");
        dish.setId("1");

        when(dishService.findById(anyString())).thenReturn(Mono.just(dish));

        mockMvc.perform(get(DishController.BASE_URL + "/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("dish1")));
    }

}