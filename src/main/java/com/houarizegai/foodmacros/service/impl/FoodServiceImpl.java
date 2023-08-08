package com.houarizegai.foodmacros.service.impl;

import com.houarizegai.foodmacros.entity.Food;
import com.houarizegai.foodmacros.entity.Macro;
import com.houarizegai.foodmacros.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FoodServiceImpl implements FoodService {

    public static final List<Food> FOODS = List.of(new Food(1, "Egg"), new Food(2, "Chicken Breast"));

    @Override
    public List<Food> getFoods() {
        return FOODS;
    }

    @Override
    public Food getFoodById(Integer id) {
        return FOODS.stream().filter(food -> id.equals(food.id())).findFirst()
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    @Override
    public Macro getFoodMacro(Food food) {
        return new Macro(new Random().nextInt(10), food.id());
    }
}
