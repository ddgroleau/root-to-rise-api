package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.ShippingAddress;
import com.rtr.api.application.dto.ShippingAddressDto;
import com.rtr.api.application.event.command.CreateShippingAddressCommand;
import com.rtr.api.application.event.query.ShippingAddressesByUserQuery;
import com.rtr.api.application.repository.abstraction.ShippingAddressRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.modelmapper.MappingException;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShippingServiceTests {
    private ShippingService shippingService;
    private final ShippingAddressRepository shippingAddressRepository = mock(ShippingAddressRepository.class);

    @BeforeAll
    void setup() {
        shippingService = new ShippingService(shippingAddressRepository);
    }

    @Test
    void handleCommand_WithValidCreateAddressCommand_savesEntity() {
        CreateShippingAddressCommand command = new CreateShippingAddressCommand();
        command.setUserId("user");
        command.setCountry("United States");
        command.setAddressLine1("addressLine1");
        command.setAddressLine2("addressLine2");
        command.setCity("city");
        command.setState("state");
        command.setZipCode("zip");
        command.setPhoneNumber("15555555555");
        when(shippingAddressRepository.saveAndFlush(any(ShippingAddress.class))).thenReturn(ShippingAddress.createInstance());

        shippingService.handleCommand(command);

        verify(shippingAddressRepository,atLeastOnce()).saveAndFlush(any(ShippingAddress.class));
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "null, United States, addressLine1, addressLine2, city, state, zip, 15555555555",
                    "user, null, addressLine1, addressLine2, city, state, zip, 15555555555",
                    "user, United States, null, addressLine2, city, state, zip, 15555555555",
                    "user, United States, addressLine1, null, city,state, zip, 15555555555",
                    "user, United States, addressLine1, addressLine2, null,state, zip, 15555555555",
                    "user, United States, addressLine1, addressLine2, city,null, zip, 15555555555",
                    "user, United States, addressLine1, addressLine2, city, state, null, 15555555555",
                    "user, United States, addressLine1, addressLine2, city, state, zip, null",
            },
            nullValues = "null"
    )
    void handleCommand_WithInvalidCreateAddressCommand_throwsException(
            String userId, String country, String address1, String address2, String city, String state, String zip, String phone
    ) {
        CreateShippingAddressCommand command = new CreateShippingAddressCommand();
        command.setUserId(userId);
        command.setCountry(country);
        command.setAddressLine1(address1);
        command.setAddressLine2(address2);
        command.setCity(city);
        command.setState(state);
        command.setZipCode(zip);
        command.setPhoneNumber(phone);

        assertThrows(MappingException.class,()->shippingService.handleCommand(command));
    }

    @Test
    void handleQuery_withValidUsername_returnsAddressList() {
        String username = "userId";
        ShippingAddress expectedAddress = ShippingAddress.createInstance();
        expectedAddress.setUserId(username);
        when(shippingAddressRepository.findByUserId(username))
                .thenReturn(new ArrayList<>(){{add(expectedAddress);}});

        List<ShippingAddressDto> shippingAddressDtos =
                (List<ShippingAddressDto>)shippingService.handleQuery(ShippingAddressesByUserQuery.getInstance(username));

        assertEquals(expectedAddress.getUserId(),shippingAddressDtos.get(0).getUserId());
    }

    @Test
    void handleQuery_withInvalidUsername_returnsEmptyCollection() {
        String username = "";
        when(shippingAddressRepository.findByUserId(username))
                .thenReturn(new ArrayList<>());

        assertThrows(
                InvalidParameterException.class,
                ()->shippingService.handleQuery(ShippingAddressesByUserQuery.getInstance(username))
        );
    }
}
