package com.rtr.api.application.repository.abstraction;

import com.rtr.api.application.domain.model.Trait;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitRepository extends JpaRepository<Trait, Integer> {
}
