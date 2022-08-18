package com.rtr.api.application.service.implementation;

import com.rtr.api.application.event.query.DistinctPropertyNamesQuery;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;

@Service("property")
public class PropertyService implements ServiceMediator {
    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;

    public PropertyService(PropertyRepository propertyRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.propertyRepository = propertyRepository;
    }

    public Object handleQuery(Query query) {
        if(query instanceof DistinctPropertyNamesQuery) return this.getDistinctPropertiesByName();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<String> getDistinctPropertiesByName() {
        Iterable<Property> properties = propertyRepository.findAll();
        return ((List<Property>) properties)
                .stream()
                .map(Property::getName)
                .sorted()
                .distinct()
                .toList();
    }
}
