package ru.nstu.sysordbackend.model.customer;

import java.util.List;

public class OrderForCustomer {
    private Long tableId;
    private List<OrderItemForCustomer> order;

    public Long getTableId() {
        return tableId;
    }

    public List<OrderItemForCustomer> getOrder() {
        return order;
    }
}
