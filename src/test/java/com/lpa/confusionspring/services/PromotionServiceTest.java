package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.LeaderMapper;
import com.lpa.confusionspring.api.v1.mapper.PromotionMapper;
import com.lpa.confusionspring.api.v1.model.PromotionDTO;
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

    @Mock
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

        List<Promotion> promotions = promotionService.findByFeatured(true).collectList().block();

        assertEquals(2, promotions.size());
    }

    @Test
    public void findById() throws Exception {
        Promotion leader = new Promotion();
        leader.setId("1");

        when(promotionReactiveRepository.findById(anyString())).thenReturn(Mono.just(leader));

        Promotion promotionReturned = promotionService.findById("1").block();

        assertNotNull("Null promotion returned", promotionReturned);
        verify(promotionReactiveRepository, times(1)).findById(anyString());
        verify(promotionReactiveRepository, never()).findAll();
    }

    @Test
    public void getPromotionsDTO() throws Exception {
        Promotion promotion = new Promotion();

        when(promotionService.getPromotions()).thenReturn(Flux.just(promotion));

        PromotionDTO promotionDTO = new PromotionDTO();

        when(promotionMapper.promotionToPromotionDTO(any(Promotion.class))).thenReturn(promotionDTO);

        List<PromotionDTO> promotions = promotionService.getPromotionsDTO().collectList().block();

        assertEquals(1, promotions.size());
        verify(promotionReactiveRepository, times(1)).findAll();
    }

    @Test
    public void findDTOByFeatured() throws Exception {
        Promotion promotion1 = new Promotion();
        promotion1.setFeatured(true);
        Promotion promotion2 = new Promotion();
        promotion2.setFeatured(true);

        when(promotionService.findByFeatured(anyBoolean())).thenReturn(Flux.fromIterable(Arrays.asList(promotion1, promotion2)));

        PromotionDTO promotionDTO = new PromotionDTO();

        when(promotionMapper.promotionToPromotionDTO(any(Promotion.class))).thenReturn(promotionDTO);

        List<PromotionDTO> promotions = promotionService.findDTOByFeatured(true).collectList().block();

        assertEquals(2, promotions.size());
    }

    @Test
    public void findDTOById() throws Exception {
        String id = "1";
        Promotion leader = new Promotion(id);

        when(promotionReactiveRepository.findById(anyString())).thenReturn(Mono.just(leader));

        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(promotionDTO.getId());

        when(promotionMapper.promotionToPromotionDTO(any(Promotion.class))).thenReturn(promotionDTO);

        PromotionDTO promotionReturned = promotionService.findDTOById("1").block();

        assertNotNull("Null promotion returned", promotionReturned);
        assertEquals(id, promotionReturned.getId());
        verify(promotionReactiveRepository, times(1)).findById(anyString());
        verify(promotionReactiveRepository, never()).findAll();
    }
}