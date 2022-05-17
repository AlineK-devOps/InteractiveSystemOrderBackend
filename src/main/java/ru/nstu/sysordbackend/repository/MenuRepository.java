package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.dish.DishesCategoryEntity;

public interface MenuRepository extends CrudRepository<DishesCategoryEntity, Long> {
}
