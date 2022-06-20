package com.rtr.api.application.dto.response;

import com.rtr.api.application.domain.model.Product;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class TraitDto {

    private Integer traitId;

    private String name;

    private String description;

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
