package com.restaurantes.model;
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
    private Double totalProce;
    private Double tip;//propina
    private Integer tableNumber;
    private Integer NumeroPeople;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.PENDING;

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

    public Double getTotalProce() {
        return totalProce;
    }

    public void setTotalProce(Double totalProce) {
        this.totalProce = totalProce;
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
                ", totalProce=" + totalProce +
                ", tip=" + tip +
                ", tableNumber=" + tableNumber +
                ", NumeroPeople=" + NumeroPeople +
                ", orderStatus=" + orderStatus +
                //", restaurant=" + restaurant +
                '}';
    }
}
