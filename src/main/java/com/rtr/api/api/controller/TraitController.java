package com.rtr.api.api.controller;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.event.query.AllTraitsQuery;
import com.rtr.api.application.dto.TraitDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/traits")
public class TraitController {

    private final ServiceMediator mediator;
    private final Logger logger;

    public TraitController( @Qualifier("trait")ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<TraitDto> getAllTraits() {
        Iterable<TraitDto> traitDtos = new ArrayList<TraitDto>();
        try {
            traitDtos = (Iterable<TraitDto>) mediator.handleQuery(AllTraitsQuery.getInstance());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return traitDtos;
        }
    }
}
