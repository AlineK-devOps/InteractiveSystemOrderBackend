package ru.nstu.sysordbackend.model;

import ru.nstu.sysordbackend.entity.DishEntity;
import ru.nstu.sysordbackend.entity.TodoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Dish {
    private Long id;
    private String category;
    private String name;
    private String composition;
    private Integer price;
    private Integer weight;
    private String imageUrl;

    public static List<Dish> toModel(List<DishEntity> entity){
        return entity.stream().map(Dish::toModel).collect(Collectors.toList());
    }
    public static Dish toModel(DishEntity entity){
        Dish model = new Dish();

        model.setId(entity.getId());
        model.setCategory(entity.getCategory());
        model.setName(entity.getName());
        model.setComposition(entity.getComposition());
        model.setPrice(entity.getPrice());
        model.setWeight(entity.getWeight());
        model.setImageUrl(entity.getImageUrl());

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}