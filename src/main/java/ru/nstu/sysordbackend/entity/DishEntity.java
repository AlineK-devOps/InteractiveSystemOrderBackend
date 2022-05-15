package ru.nstu.sysordbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String composition;
    private Integer price;
    private Integer weight;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private DishesCategoryEntity category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category.getName();
    }
}