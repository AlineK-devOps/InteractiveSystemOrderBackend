package ru.nstu.sysordbackend.model.waiter;

import ru.nstu.sysordbackend.entity.dish.DishEntity;

public class DishForWaiter {
    private String name;
    private Integer weight;
    private Integer cookingTime;

    public static DishForWaiter toModel(DishEntity entity){
        DishForWaiter model = new DishForWaiter();

        model.setName(entity.getName());
        model.setWeight(entity.getWeight());
        model.setCookingTime(entity.getCooking_time());

        return model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }
}
