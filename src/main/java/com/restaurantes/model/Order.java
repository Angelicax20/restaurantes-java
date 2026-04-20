package com.restaurantes.model;
import com.restaurantes.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Pedidos")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime fecha = LocalDateTime.now();
    private Double totalPrice;
    private Double tip;//propina
    private Integer tableNumber;
    private Integer NumeroPeople;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; //= OrderStatus.PENDING;

    @ManyToOne
    private Restaurant restaurant;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getNumeroPeople() {
        return NumeroPeople;
    }

    public void setNumeroPeople(Integer numeroPeople) {
        NumeroPeople = numeroPeople;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", totalPrice=" + totalPrice +
                ", tip=" + tip +
                ", tableNumber=" + tableNumber +
                ", NumeroPeople=" + NumeroPeople +
                ", orderStatus=" + orderStatus +
                //", restaurant=" + restaurant +
                '}';
    }
}
