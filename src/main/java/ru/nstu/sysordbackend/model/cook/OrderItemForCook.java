package ru.nstu.sysordbackend.model.cook;

import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemForCook {

    private Long id;
    private DishForCook dish;
    private String status;

    private Timestamp orderTime;

    private String cook;

    public static List<OrderItemForCook> toModel(List<OrderItemEntity> entityList){
        return entityList.stream().map(OrderItemForCook::toModel).collect(Collectors.toList());
    }

    public static OrderItemForCook toModel(OrderItemEntity entity){
        OrderItemForCook model = new OrderItemForCook();

        model.setId(entity.getId());
        model.setDish(DishForCook.toModel(entity.getDish()));
        model.setStatus(entity.getStatus());
        model.setOrderTime(entity.getOrderTime());
        model.setCook(entity.getCook() != null? entity.getCook().getName() : null);

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

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
