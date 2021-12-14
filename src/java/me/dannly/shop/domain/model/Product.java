/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.dannly.shop.domain.model;

/**
 *
 * @author vinix
 */
public class Product {

    private final Integer id;
    private final String name;
    private final String description;
    private final String extraInfo;
    private final Float weight;
    private final Boolean highlighted;
    private final Boolean active;
    private final String image;
    private final Integer categoriesId;

    public Product(Integer id, String name, String description, String extraInfo, Float weight, Boolean highlighted, Boolean active, String image, Integer categoriesId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.extraInfo = extraInfo;
        this.weight = weight;
        this.highlighted = highlighted;
        this.active = active;
        this.image = image;
        this.categoriesId = categoriesId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public Float getWeight() {
        return weight;
    }

    public Boolean getHighlighted() {
        return highlighted;
    }

    public Boolean getActive() {
        return active;
    }

    public String getImage() {
        return image;
    }

    public Integer getCategoriesId() {
        return categoriesId;
    }
}
