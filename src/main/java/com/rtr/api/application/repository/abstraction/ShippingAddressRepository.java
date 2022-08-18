package com.rtr.api.application.repository.abstraction;

import com.rtr.api.application.domain.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {
    List<ShippingAddress> findByUserId(String userId);
}
