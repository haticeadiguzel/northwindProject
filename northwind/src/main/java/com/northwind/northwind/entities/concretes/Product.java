package com.northwind.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //how id will increase
    private int id; //smallint

    @Column(name = "product_name")
    private String productName; //character varying (40)

    @Column(name = "unit_price")
    private double unitPrice; //real

    @Column(name = "units_in_stock")
    private short unitsInStock; //smallint

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit; ///character varying (20)

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
