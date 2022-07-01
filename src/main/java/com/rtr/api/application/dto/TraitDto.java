package com.rtr.api.application.dto;

import java.util.Objects;

public class TraitDto {

    private Integer traitId;

    private String name;

    private String description;

    @Override
    public boolean equals(Object basis) {
        if (basis == null || this.getClass() != basis.getClass()) return false;
        return this == basis || Objects.equals(name, ((TraitDto)basis).name);
    }
    public Integer getTraitId() {
        return traitId;
    }

    public void setTraitId(Integer traitId) {
        this.traitId = traitId;
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
