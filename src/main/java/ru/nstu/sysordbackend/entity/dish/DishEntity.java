package ru.nstu.sysordbackend.entity.dish;

import ru.nstu.sysordbackend.entity.order.OrderItemEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
public class DishEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String composition;
    private Integer price;
    private Integer weight;

    private Integer cooking_time;
    private String imageUrl;

    private String recipe;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private DishesCategoryEntity category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish")
    private List<OrderItemEntity> orderItems;

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

    public Integer getCooking_time() {
        return cooking_time;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public String getRecipe() {
        return recipe;
    }
}