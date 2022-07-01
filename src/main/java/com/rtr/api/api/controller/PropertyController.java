package com.rtr.api.api.controller;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.event.query.DistinctPropertyNamesQuery;
import com.rtr.api.application.dto.PropertyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final ServiceMediator mediator;
    private final Logger logger;

    public PropertyController(@Qualifier("property") ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(PropertyController.class);
    }

    @GetMapping("/names/distinct")
    public Iterable<String> getDistinctPropertyNames() {
        Iterable<String> names = new ArrayList<String>();
        try {
            names = (Iterable<String>) mediator.handleQuery(DistinctPropertyNamesQuery.getInstance());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return names;
        }
    }

}
