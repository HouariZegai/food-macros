package com.houarizegai.foodmacros.service;

import com.houarizegai.foodmacros.entity.Food;
import com.houarizegai.foodmacros.entity.Macro;

import java.util.List;

public interface FoodService {

    List<Food> getFoods();

    Food getFoodById(Integer id);

    Macro getFoodMacro(Food food);
}
