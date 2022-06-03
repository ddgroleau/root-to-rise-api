package com.rtr.api.application.repository.abstraction;

import com.rtr.api.application.domain.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}