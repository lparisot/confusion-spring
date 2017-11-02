package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Dish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DishReactiveRepositoryTest {
    private static String NAME="FOO";

    @Autowired
    private DishReactiveRepository dishReactiveRepository;

    @Before
    public void setUp() throws Exception {
        dishReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Dish dish = new Dish();
        dish.setName("TEST");
        dish.setDescription("Yummy");

        dishReactiveRepository.save(dish).block();

        Long count = dishReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByName() throws Exception {
        // given
        Dish dish = new Dish();
        dish.setName(NAME);
        dish.setDescription("Yummy");

        dishReactiveRepository.save(dish).block();

        //when
        Dish fetchedDish = dishReactiveRepository.findByName(NAME).block();

        //then
        assertNotNull(fetchedDish.getId());
        assertEquals(NAME, fetchedDish.getName());
    }

    @Test
    public void testGetAllFeatured() throws Exception {
        // given
        Dish dish1 = new Dish();
        dish1.setName("Featured");
        dish1.setFeatured(true);

        Dish dish2 = new Dish();
        dish2.setName("Not Featured");
        dish2.setFeatured(false);

        Dish dish3 = new Dish();
        dish3.setName("Featured");
        dish3.setFeatured(true);

        dishReactiveRepository.save(dish1).block();
        dishReactiveRepository.save(dish2).block();
        dishReactiveRepository.save(dish3).block();

        //when
        Flux<Dish> featuredDishes = dishReactiveRepository.findByFeatured(true);

        //then
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] count = {0};
        featuredDishes
                .doOnComplete(countDownLatch::countDown)
                .subscribe((Dish dish) -> {
                    assertEquals(true, dish.isFeatured());
                    count[0]++;
                });
        countDownLatch.await();
        assertEquals(2, count[0]);
    }
}