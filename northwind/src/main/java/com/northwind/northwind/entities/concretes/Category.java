package com.northwind.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}
