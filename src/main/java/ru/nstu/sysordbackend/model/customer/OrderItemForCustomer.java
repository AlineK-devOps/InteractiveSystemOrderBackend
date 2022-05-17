package ru.nstu.sysordbackend.model.customer;

public class OrderItemForCustomer {
    private Long dishId;
    private Integer count;

    public Long getDishId() {
        return dishId;
    }

    public Integer getCount() {
        return count;
    }
}
