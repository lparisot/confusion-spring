package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.PromotionDTO;
import com.lpa.confusionspring.domain.Promotion;
import org.junit.Test;

import static org.junit.Assert.*;

public class PromotionMapperTest {
    private String NAME = "Doe";
    private String ID = "ID";
    private PromotionMapper promotionMapper = PromotionMapper.INSTANCE;

    @Test
    public void promotionToPromotionDTO() throws Exception {
        //given
        Promotion promotion = new Promotion();
        promotion.setId(ID);
        promotion.setName(NAME);

        //when
        PromotionDTO promotionDTO = promotionMapper.promotionToPromotionDTO(promotion);

        //then
        assertEquals(ID, promotionDTO.getId());
        assertEquals(NAME, promotionDTO.getName());
    }

    @Test
    public void promotionDTOToPromotion() throws Exception {
        //given
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(ID);
        promotionDTO.setName(NAME);

        //when
        Promotion promotion = promotionMapper.promotionDTOToPromotion(promotionDTO);

        //then
        assertEquals(ID, promotion.getId());
        assertEquals(NAME, promotion.getName());
    }

}