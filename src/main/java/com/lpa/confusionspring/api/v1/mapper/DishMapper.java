package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.domain.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishMapper INSTANCE = Mappers.getMapper(DishMapper.class);

    DishDTO dishToDishDTO(Dish dish);

    Dish dishDTOToDish(DishDTO dishDTO);
}
