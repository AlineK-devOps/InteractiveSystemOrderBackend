package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.order.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByTableId(Long tableId);
    List<OrderEntity> findAll();
}
