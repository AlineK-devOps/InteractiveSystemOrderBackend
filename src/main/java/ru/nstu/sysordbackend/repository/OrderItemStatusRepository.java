package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.order.OrderItemStatusEntity;

public interface OrderItemStatusRepository extends CrudRepository<OrderItemStatusEntity, Long> {
    OrderItemStatusEntity findByName(String name);
}
