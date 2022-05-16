package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.OrderItemEntity;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {
}
