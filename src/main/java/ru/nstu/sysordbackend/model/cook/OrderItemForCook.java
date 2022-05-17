package ru.nstu.sysordbackend.model.cook;

import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemForCook {
    private DishForCook dish;
    private String status;

    public static List<OrderItemForCook> toModel(List<OrderItemEntity> entityList){
        return entityList.stream().map(OrderItemForCook::toModel).collect(Collectors.toList());
    }

    public static OrderItemForCook toModel(OrderItemEntity entity){
        OrderItemForCook model = new OrderItemForCook();

        model.setDish(DishForCook.toModel(entity.getDish()));
        model.setStatus(entity.getStatus());

        return model;
    }

    public DishForCook getDish() {
        return dish;
    }

    public void setDish(DishForCook dish) {
        this.dish = dish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
