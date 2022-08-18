package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ShippingAddressDto;
import com.rtr.api.application.event.command.CreateShippingAddressCommand;
import com.rtr.api.application.event.query.ShippingAddressesByUserQuery;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    private final ServiceMediator mediator;
    private final Logger logger;

    public ShippingController(@Qualifier("shipping") ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ShippingController.class);
    }

    @GetMapping("/addresses/{username}")
    public List<ShippingAddressDto> getShippingAddressesByUser(@PathVariable String username) {
        try {
            List<ShippingAddressDto> shippingAddressDtos = (List<ShippingAddressDto>)mediator.handleQuery(ShippingAddressesByUserQuery.getInstance(username));
            return shippingAddressDtos;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @PostMapping("/addresses/create")
    public ResponseEntity<String> createShippingAddress(CreateShippingAddressCommand createShippingAddressCommand)  {
        try {
            mediator.handleCommand(createShippingAddressCommand);
            return ResponseEntity.status(HttpStatus.CREATED).body("Shipping address created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Could not create shipping address.");
        }
    }
}
