package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.DishEntity;

public interface DishesRepository extends CrudRepository<DishEntity, Long>{
}
