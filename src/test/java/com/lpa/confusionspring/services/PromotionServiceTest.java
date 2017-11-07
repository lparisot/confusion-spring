package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.LeaderMapper;
import com.lpa.confusionspring.api.v1.mapper.PromotionMapper;
import com.lpa.confusionspring.domain.Promotion;
import com.lpa.confusionspring.repositories.reactive.LeaderReactiveRepository;
import com.lpa.confusionspring.repositories.reactive.PromotionReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PromotionServiceTest {
    private PromotionService promotionService;

    @Mock
    private PromotionReactiveRepository promotionReactiveRepository;

    private PromotionMapper promotionMapper = PromotionMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
        // tell mockito to give me a mock recipe repository
        MockitoAnnotations.initMocks(this);

        promotionService = new PromotionServiceImpl(promotionReactiveRepository);
    }

    @Test
    public void getPromotions() throws Exception {
        Promotion promotion = new Promotion();

        when(promotionService.getPromotions()).thenReturn(Flux.just(promotion));

        List<Promotion> promotions = promotionService.getPromotions().collectList().block();

        assertEquals(1, promotions.size());
        verify(promotionReactiveRepository, times(1)).findAll();
    }

    @Test
    public void findByFeatured() throws Exception {
        Promotion promotion1 = new Promotion();
        promotion1.setFeatured(true);
        Promotion promotion2 = new Promotion();
        promotion2.setFeatured(true);

        when(promotionService.findByFeatured(anyBoolean())).thenReturn(Flux.fromIterable(Arrays.asList(promotion1, promotion2)));

        List<Promotion> leaders = promotionService.findByFeatured(true).collectList().block();

        assertEquals(2, leaders.size());
    }

    @Test
    public void findById() throws Exception {
        Promotion leader = new Promotion();
        leader.setId("1");

        when(promotionReactiveRepository.findById(anyString())).thenReturn(Mono.just(leader));

        Promotion leaderReturned = promotionService.findById("1").block();

        assertNotNull("Null recipe returned", leaderReturned);
        verify(promotionReactiveRepository, times(1)).findById(anyString());
        verify(promotionReactiveRepository, never()).findAll();
    }

}