package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.ShippingAddress;
import com.rtr.api.application.dto.ShippingAddressDto;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.command.CreateShippingAddressCommand;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.event.query.ShippingAddressesByUserQuery;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.repository.abstraction.ShippingAddressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service("shipping")
public class ShippingService implements ServiceMediator {

    private final ShippingAddressRepository shippingAddressRepository;
    private final ModelMapper modelMapper;

    public ShippingService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    public Object handleQuery(Query query) {
        if(query instanceof ShippingAddressesByUserQuery) return this.getShippingAddressesByUser((ShippingAddressesByUserQuery) query);
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        if(command instanceof CreateShippingAddressCommand) {
            this.createShippingAddress((CreateShippingAddressCommand) command);
            return;
        }
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    private List<ShippingAddressDto> getShippingAddressesByUser(ShippingAddressesByUserQuery query) {
        if(query == null || query.getUsername() == null || query.getUsername().isBlank())
            throw new InvalidParameterException("Invalid user ID.");

        List<ShippingAddress> shippingAddresses = shippingAddressRepository.findByUserId(query.getUsername());
        return shippingAddresses.stream()
                .map(address -> modelMapper.map(address,ShippingAddressDto.class))
                .toList();
    }

    private void createShippingAddress(CreateShippingAddressCommand createShippingAddressCommand) throws InvalidParameterException {
        ShippingAddress shippingAddress = modelMapper.map(createShippingAddressCommand,ShippingAddress.class);
        shippingAddressRepository.saveAndFlush(shippingAddress);
    }
}
