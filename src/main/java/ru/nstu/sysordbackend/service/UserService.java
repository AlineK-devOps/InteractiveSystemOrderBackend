package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.entity.UserEntity;
import ru.nstu.sysordbackend.exception.UserAlreadyExistException;
import ru.nstu.sysordbackend.exception.UserNotFoundException;
import ru.nstu.sysordbackend.model.User;
import ru.nstu.sysordbackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {

        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExistException("Такой пользователь уже существует");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        if (userRepository.findById(id).isPresent())
            return User.toModel(userRepository.findById(id).get());
        else
            throw new UserNotFoundException("Пользователь не найден");
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
