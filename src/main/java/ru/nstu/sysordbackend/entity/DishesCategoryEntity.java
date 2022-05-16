package ru.nstu.sysordbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes_categories")
public class DishesCategoryEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<DishEntity> dishes;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DishEntity> getDishes() {
        return dishes;
    }
}