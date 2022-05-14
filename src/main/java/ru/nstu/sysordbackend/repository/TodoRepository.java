package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.TodoEntity;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
