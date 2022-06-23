package com.rtr.api.application.service.implementation;

import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.ArrayList;

@Service
@Qualifier("property")
public class PropertyService implements ServiceMediator {
    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;

    public PropertyService(PropertyRepository propertyRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.propertyRepository = propertyRepository;
    }

    public Object handleQuery(Query query) {
        if(query instanceof AllProductsQuery) return this.getAllProperties();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<PropertyDto> getAllProperties() {
        Iterable<Property> properties = propertyRepository.findAll();
        ArrayList<PropertyDto> propertyDtos = new ArrayList<PropertyDto>();
        for (Property property: properties) {
            PropertyDto propertyDto = modelMapper.map(property,PropertyDto.class);
            propertyDtos.add(propertyDto);
        }
        return propertyDtos;
    }
}
