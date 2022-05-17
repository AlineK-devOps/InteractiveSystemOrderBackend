package ru.nstu.sysordbackend.model.waiter;

import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemForWaiter {
    private DishForWaiter dish;
    private String status;

    public static List<OrderItemForWaiter> toModel(List<OrderItemEntity> entityList) {
        return entityList.stream().map(OrderItemForWaiter::toModel).collect(Collectors.toList());
    }

    public static OrderItemForWaiter toModel(OrderItemEntity entity) {
        OrderItemForWaiter model = new OrderItemForWaiter();

        model.setDish(DishForWaiter.toModel(entity.getDish()));
        model.setStatus(entity.getStatus());

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
}