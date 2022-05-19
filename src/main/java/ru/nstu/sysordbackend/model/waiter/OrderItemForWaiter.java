package ru.nstu.sysordbackend.model.waiter;

import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemForWaiter {

    private Long id;
    private DishForWaiter dish;
    private String status;

    private Timestamp orderTime;

    private String cook;

    private String waiter;

    public static List<OrderItemForWaiter> toModel(List<OrderItemEntity> entityList) {
        return entityList.stream().map(OrderItemForWaiter::toModel).collect(Collectors.toList());
    }

    public static OrderItemForWaiter toModel(OrderItemEntity entity) {
        OrderItemForWaiter model = new OrderItemForWaiter();

        model.setId(entity.getId());
        model.setDish(DishForWaiter.toModel(entity.getDish()));
        model.setStatus(entity.getStatus());
        model.setOrderTime(entity.getOrderTime());
        model.setCook(entity.getCook() != null? entity.getCook().getName() : null);
        model.setWaiter(entity.getWaiter() != null? entity.getWaiter().getName() : null);

        return model;
    }

    public DishForWaiter getDish() {
        return dish;
    }

    public void setDish(DishForWaiter dish) {
        this.dish = dish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
}