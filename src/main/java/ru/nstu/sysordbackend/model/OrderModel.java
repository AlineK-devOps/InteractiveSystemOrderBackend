package ru.nstu.sysordbackend.model;

import java.util.List;

public class OrderModel {
    private Long tableId;
    private List<OrderItemModel> order;

    public Long getTableId() {
        return tableId;
    }

    public List<OrderItemModel> getOrder() {
        return order;
    }
}
