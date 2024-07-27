package com.workspacesier.cardapiofullstack.controller;

import com.workspacesier.cardapiofullstack.food.Food;
import com.workspacesier.cardapiofullstack.food.FoodRepository;
import com.workspacesier.cardapiofullstack.food.FoodResponseDTO;
import com.workspacesier.cardapiofullstack.food.FoodRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;


    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }


    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
