package com.restaurantes.controller;


import com.restaurantes.model.Dish;
import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.DishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DishController {
    //Importar de que clase queremos traer
    private DishRepository dishRepository;
//  Constructor
        public DishController(DishRepository dishRepository) {
            this.dishRepository = dishRepository;
        }

        @GetMapping("dishes/{id}")
        public String dishDetail(@PathVariable Long id, Model model) {

            Optional<Dish> dishOptional = dishRepository.findById(id);
            if (dishOptional.isPresent()) {
                Dish dish = dishOptional.get();
                model.addAttribute("dish", dish);
                return "dishes/dish-detail";
        }
        return "redirect:/restaurants";
    }
}
