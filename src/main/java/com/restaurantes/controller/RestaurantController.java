package com.restaurantes.controller;
import com.restaurantes.model.Restaurant;
import com.restaurantes.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller//traer dato y cargarlos en la vista
public class RestaurantController {

    //inyectar
    private RestaurantRepository restaurantRepository;
    //Constructor
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


//get all restaurants
    @GetMapping("restaurants")//pluras ya que se devuelve una lista de restaurantes
    public String restaurantList (Model model){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        model.addAttribute("restaurants",restaurantRepository.findAll() );//ESTO AGREGA UN ATRIBUTO AL MODELO CON EL NOMBRE "RESTAURANTS" Y EL VALOR DE LA LISTA DE RESTAURANTES OBTENIDA DEL REPOSITORIO, ESTE ATRIBUTO PUEDE SER USADO EN LA VISTA PARA MOSTRAR LA LISTA DE RESTAURANTES
        model.addAttribute("title", "Lista de restaurantes");//ESTO AGREGA UN ATRIBUTO AL MODELO CON EL NOMBRE "TITLE" Y EL VALOR "LISTA DE RESTAURANTES", ESTE ATRIBUTO PUEDE SER USADO EN LA VISTA PARA MOSTRAR UN TITULO O ENCABEZADO)
        model.addAttribute("numRestaurantes", restaurants.size());
        return "restaurants/restaurant-list";
    }

    //nuevo metodo para traer un restaurant por id
    @GetMapping("restaurants/{id}")//
    public String restaurantDetail(Model model, @PathVariable Long id){
        //buscar restaurante por ID
        Optional<Restaurant> restaurants = restaurantRepository.findById(id);
        if (restaurants.isPresent()) {
            //existe el restaurante
            Restaurant restaurant= restaurants.get();
            model.addAttribute("restaurant", restaurant);
            return  "restaurants/restaurant-detail";
        } else {
            //no existe el restaurante
            model.addAttribute("errorMessage", "Restaurante no encontrado");
            return  "redirect:/restaurants";
        }
        //return "restaurants/restaurant-detail";
    }


}

