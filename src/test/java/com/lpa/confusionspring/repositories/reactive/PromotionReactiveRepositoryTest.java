package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Promotion;
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
public class PromotionReactiveRepositoryTest {
    private static String NAME="FOO";

    @Autowired
    private PromotionReactiveRepository promotionReactiveRepository;

    @Before
    public void setUp() throws Exception {
        promotionReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Promotion promotion = new Promotion();
        promotion.setName("TEST");
        promotion.setDescription("Yummy");

        promotionReactiveRepository.save(promotion).block();

        Long count = promotionReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void findByFeatured() throws Exception {
        // given
        Promotion promotion1 = new Promotion();
        promotion1.setName("Featured");
        promotion1.setFeatured(true);

        Promotion promotion2 = new Promotion();
        promotion2.setName("Not Featured");
        promotion2.setFeatured(false);

        Promotion promotion3 = new Promotion();
        promotion3.setName("Featured");
        promotion3.setFeatured(true);

        promotionReactiveRepository.save(promotion1).block();
        promotionReactiveRepository.save(promotion2).block();
        promotionReactiveRepository.save(promotion3).block();

        //when
        Flux<Promotion> featuredLeaders = promotionReactiveRepository.findByFeatured(true);

        //then
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] count = {0};
        featuredLeaders
                .doOnComplete(countDownLatch::countDown)
                .subscribe((Promotion promotion) -> {
                    assertEquals(true, promotion.isFeatured());
                    count[0]++;
                });
        countDownLatch.await();
        assertEquals(2, count[0]);
    }

}