package ru.nstu.sysordbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nstu.sysordbackend.exception.CategoryNotFoundException;
import ru.nstu.sysordbackend.model.Dish;
import ru.nstu.sysordbackend.repository.MenuRepository;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Dish> getMenuByCategory(Long id) throws CategoryNotFoundException {
        if (menuRepository.findById(id).isPresent())
            return Dish.toModel(menuRepository.findById(id).get().getDishes());
        else
            throw new CategoryNotFoundException("Категория не найдена");
    }
}