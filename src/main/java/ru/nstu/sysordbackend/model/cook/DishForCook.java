package ru.nstu.sysordbackend.model.cook;

import ru.nstu.sysordbackend.entity.dish.DishEntity;

public class DishForCook {

    private String name;
    private Integer weight;
    private Integer cookingTime;
    private String imageUrl;
    private String recipe;

    public static DishForCook toModel(DishEntity entity){
        DishForCook model = new DishForCook();

        model.setName(entity.getName());
        model.setWeight(entity.getWeight());
        model.setCookingTime(entity.getCooking_time());
        model.setRecipe(entity.getRecipe());
        model.setImageUrl(entity.getImageUrl());

        return model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRecipe() {
        return recipe;
    }
}
