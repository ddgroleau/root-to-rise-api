package com.rtr.api.application.dto.response;

import java.util.Set;
public class ProductDto {
    private Integer productId;

    private String name;

    private String type;

    private String valueProposition;

    private String description;

    private Double price;

    private Integer stockQuantity;

    private Double measurementSize;

    private String measurementUnit;

    private String useCases;

    private String instructions;

    private String disclaimer;

    private String imagePath;

    private Set<IngredientDto> ingredients;

    private Set<PropertyDto> properties;

    private Set<TraitDto> traits;

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

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getMeasurementSize() {
        return measurementSize;
    }

    public void setMeasurementSize(Double measurementSize) {
        this.measurementSize = measurementSize;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getUseCases() {
        return useCases;
    }

    public void setUseCases(String useCases) {
        this.useCases = useCases;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<PropertyDto> getProperties() {
        return properties;
    }

    public void setProperties(Set<PropertyDto> properties) {
        this.properties = properties;
    }

    public Set<TraitDto> getTraits() {
        return traits;
    }

    public void setTraits(Set<TraitDto> traits) {
        this.traits = traits;
    }
}
