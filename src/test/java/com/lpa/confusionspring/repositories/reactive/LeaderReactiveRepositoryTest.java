package com.lpa.confusionspring.repositories.reactive;

import com.lpa.confusionspring.domain.Leader;
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
public class LeaderReactiveRepositoryTest {
    private static String NAME="FOO";

    @Autowired
    private LeaderReactiveRepository leaderReactiveRepository;

    @Before
    public void setUp() throws Exception {
        leaderReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        Leader leader = new Leader();
        leader.setName("TEST");
        leader.setDescription("Yummy");

        leaderReactiveRepository.save(leader).block();

        Long count = leaderReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void findByFeatured() throws Exception {
        // given
        Leader leader1 = new Leader();
        leader1.setName("Featured");
        leader1.setFeatured(true);

        Leader leader2 = new Leader();
        leader2.setName("Not Featured");
        leader2.setFeatured(false);

        Leader leader3 = new Leader();
        leader3.setName("Featured");
        leader3.setFeatured(true);

        leaderReactiveRepository.save(leader1).block();
        leaderReactiveRepository.save(leader2).block();
        leaderReactiveRepository.save(leader3).block();

        //when
        Flux<Leader> featuredLeaders = leaderReactiveRepository.findByFeatured(true);

        //then
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] count = {0};
        featuredLeaders
                .doOnComplete(countDownLatch::countDown)
                .subscribe((Leader leader) -> {
                    assertEquals(true, leader.isFeatured());
                    count[0]++;
                });
        countDownLatch.await();
        assertEquals(2, count[0]);
    }

}