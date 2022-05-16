package ru.nstu.sysordbackend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.nstu.sysordbackend.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
