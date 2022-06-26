package com.rtr.api.application.service.implementation;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Trait;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllTraitsQuery;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.TraitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Service("trait")
public class TraitService implements ServiceMediator {
    private final TraitRepository traitRepository;
    private final ModelMapper modelMapper;

    public TraitService(TraitRepository traitRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.traitRepository = traitRepository;
    }

    public Object handleQuery(Query query) {
        if(query instanceof AllTraitsQuery) return this.getAllTraits();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<TraitDto> getAllTraits() {
        Iterable<Trait> traits = traitRepository.findAll();
        ArrayList<TraitDto> traitDtos = new ArrayList<TraitDto>();
        for (Trait trait: traits) {
            TraitDto traitDto = modelMapper.map(trait,TraitDto.class);
            traitDtos.add(traitDto);
        }
        return traitDtos;
    }
}
