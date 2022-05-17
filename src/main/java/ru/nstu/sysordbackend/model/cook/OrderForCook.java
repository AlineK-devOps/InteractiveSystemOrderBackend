package ru.nstu.sysordbackend.model.cook;

import java.util.List;

public class OrderForCook {
    private Long tableId;
    private List<OrderItemForCook> order;

    public Long getTableId() {
        return tableId;
    }

    public List<OrderItemForCook> getOrder() {
        return order;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public void setOrder(List<OrderItemForCook> order) {
        this.order = order;
    }
}
