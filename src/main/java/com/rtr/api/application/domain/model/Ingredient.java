package com.rtr.api.application.domain.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ingredients")
public class Ingredient {
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @Id
    @GeneratedValue
    @Column(name="ingredient_id")
    private Integer ingredientId;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="alternate_name")
    private String alternateName;

    @Column(name="display_order")
    private Integer displayOrder;

    @Column(name="description")
    private String description;

    @Column(name="image_path")
    private String imagePath;

    @NotNull
    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="created_by")
    private String createdBy;

    @NotNull
    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @Column(name="updated_by")
    private String updatedBy;

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
