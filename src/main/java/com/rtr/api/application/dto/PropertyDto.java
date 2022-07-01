package com.rtr.api.application.dto;

import java.util.Objects;

public class PropertyDto {

    private Integer propertyId;

    private String name;

    private String description;

    @Override
    public boolean equals(Object basis) {
        if (basis == null || this.getClass() != basis.getClass()) return false;
        return this == basis || Objects.equals(name, ((PropertyDto)basis).name);
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
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
}
