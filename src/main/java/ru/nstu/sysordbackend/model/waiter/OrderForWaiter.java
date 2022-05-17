package ru.nstu.sysordbackend.model.waiter;

import java.util.List;

public class OrderForWaiter {
    private Long tableId;
    private List<OrderItemForWaiter> order;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public List<OrderItemForWaiter> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItemForWaiter> order) {
        this.order = order;
    }
}
