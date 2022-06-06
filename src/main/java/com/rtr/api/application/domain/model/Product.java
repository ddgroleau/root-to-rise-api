package com.rtr.api.application.domain.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Integer productId;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="value_proposition")
    private String valueProposition;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @Column(name="stock_quantity")
    private Integer stockQuantity;

    @Column(name="measurement_size")
    private Double measurementSize;

    @Column(name="measurement_unit")
    private String measurementUnit;

    @Column(name="use_cases")
    private String useCases;

    @Column(name="instructions")
    private String instructions;

    @Column(name="disclaimer")
    private String disclaimer;

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

    @OneToMany(mappedBy = "product")
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy = "product")
    private Set<Property> properties;

    @OneToMany(mappedBy = "product")
    private Set<Trait> traits;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUseCases() {
        return useCases;
    }

    public void setUseCases(String useCases) {
        this.useCases = useCases;
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

    public Double getMeasurementSize() {
        return measurementSize;
    }

    public void setMeasurementSize(Double measurementSize) {
        this.measurementSize = measurementSize;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<Trait> getTraits() {
        return traits;
    }

    public void setTraits(Set<Trait> traits) {
        this.traits = traits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueProposition() {
        return valueProposition;
    }

    public void setValueProposition(String valueProposition) {
        this.valueProposition = valueProposition;
    }
}
