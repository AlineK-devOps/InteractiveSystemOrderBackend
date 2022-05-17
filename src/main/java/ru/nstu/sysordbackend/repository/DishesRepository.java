package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.dish.DishEntity;

public interface DishesRepository extends CrudRepository<DishEntity, Long>{
}
