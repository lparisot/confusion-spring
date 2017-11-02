package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.PromotionDTO;
import com.lpa.confusionspring.domain.Promotion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    PromotionMapper INSTANCE = Mappers.getMapper(PromotionMapper.class);

    PromotionDTO promotionToPromotionDTO(Promotion promotion);

    Promotion promotionDTOToPromotion(PromotionDTO promotionDTO);
}
