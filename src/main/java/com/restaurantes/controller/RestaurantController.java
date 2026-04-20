package com.restaurantes.controller;
import com.restaurantes.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//traer dato y cargarlos en la vista
public class RestaurantController {

    //inyectar
    private RestaurantRepository restaurantRepository;
    //Constructor
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("restaurants/restaurant-list")//pluras ya que se devuelve una lista de restaurantes
    public String restaurantList (Model model){
        model.addAttribute("restaurants",restaurantRepository.findAll() );//ESTO AGREGA UN ATRIBUTO AL MODELO CON EL NOMBRE "RESTAURANTS" Y EL VALOR DE LA LISTA DE RESTAURANTES OBTENIDA DEL REPOSITORIO, ESTE ATRIBUTO PUEDE SER USADO EN LA VISTA PARA MOSTRAR LA LISTA DE RESTAURANTES
        return "restaurants/restaurant-list";
    }
}

