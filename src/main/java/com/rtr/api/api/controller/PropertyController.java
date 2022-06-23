package com.rtr.api.api.controller;

import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.event.query.AllPropertiesQuery;
import com.rtr.api.application.dto.PropertyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    @Qualifier("property")
    private final ServiceMediator mediator;
    private final Logger logger;

    public PropertyController(ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<PropertyDto> getAllProperties() {
        Iterable<PropertyDto> propertyDtos = new ArrayList<PropertyDto>();
        try {
            propertyDtos = (Iterable<PropertyDto>) mediator.handleQuery(AllPropertiesQuery.getInstance());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return propertyDtos;
        }
    }

}
