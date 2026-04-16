package com.restaurantes.repository;
import com.restaurantes.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //Consultas personalizadas

    //findByRestaurantId(Long restaurantId); -Este permite traer todos los pedidos de un restaurant

}