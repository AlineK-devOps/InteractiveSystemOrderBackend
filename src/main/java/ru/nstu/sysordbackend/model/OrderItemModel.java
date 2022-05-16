package ru.nstu.sysordbackend.model;

public class OrderItemModel {
    private Long dishId;
    private Integer count;

    public Long getDishId() {
        return dishId;
    }

    public Integer getCount() {
        return count;
    }
}
