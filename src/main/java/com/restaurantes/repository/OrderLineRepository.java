package com.restaurantes.repository;

import com.restaurantes.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query("SELECT SUM(ol.quantity * ol.dish.price ) FROM OrderLine ol WHERE ol.order.id = :orderId")
    Double calculateTotalPrice(Long orderId);

}