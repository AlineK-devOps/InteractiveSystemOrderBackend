package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.entity.UserEntityTest;
import ru.nstu.sysordbackend.exception.UserAlreadyExistException;
import ru.nstu.sysordbackend.exception.UserNotFoundException;
import ru.nstu.sysordbackend.model.UserTest;
import ru.nstu.sysordbackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntityTest registration(UserEntityTest user) throws UserAlreadyExistException {
        return new UserEntityTest();
    }

    public UserTest getUser(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isPresent())
            return new UserTest();
        else
            throw new UserNotFoundException("Пользователь не найден");
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
