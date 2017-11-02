package com.lpa.confusionspring.api.v1.mapper;

import com.lpa.confusionspring.api.v1.model.DishDTO;
import com.lpa.confusionspring.domain.Dish;
import org.junit.Test;

import static org.junit.Assert.*;

public class DishMapperTest {
    private String NAME = "Doe";
    private String ID = "ID";
    private DishMapper dishMapper = DishMapper.INSTANCE;

    @Test
    public void dishToDishDTO() throws Exception {
        //given
        Dish dish = new Dish();
        dish.setId(ID);
        dish.setName(NAME);

        //when
        DishDTO dishDTO = dishMapper.dishToDishDTO(dish);

        //then
        assertEquals(ID, dishDTO.getId());
        assertEquals(NAME, dishDTO.getName());
    }

    @Test
    public void dishDTOToDish() throws Exception {
        //given
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(ID);
        dishDTO.setName(NAME);

        //when
        Dish dish = dishMapper.dishDTOToDish(dishDTO);

        //then
        assertEquals(ID, dish.getId());
        assertEquals(NAME, dish.getName());
    }

}