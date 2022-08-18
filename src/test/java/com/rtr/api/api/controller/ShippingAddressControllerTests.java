package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ShippingAddressDto;
import com.rtr.api.application.event.command.CreateShippingAddressCommand;
import com.rtr.api.application.event.query.ShippingAddressesByUserQuery;
import com.rtr.api.application.service.implementation.ShippingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShippingAddressControllerTests {
    private ShippingService shippingService;
    private ShippingController shippingController;

    @BeforeAll
    void setup() {
        shippingService = mock(ShippingService.class);
        shippingController = new ShippingController(shippingService);
    }

    @Test
    void createShippingAddress_WithValidCreateAddressCommand_returns201() {
        CreateShippingAddressCommand command = new CreateShippingAddressCommand();
        command.setUserId("user");
        command.setCountry("United States");
        command.setAddressLine1("addressLine1");
        command.setAddressLine2("addressLine2");
        command.setCity("city");
        command.setState("state");
        command.setZipCode("zip");
        command.setPhoneNumber("15555555555");
        doNothing().when(shippingService).handleCommand(command);

        ResponseEntity<String> actualResponse = shippingController.createShippingAddress(command);

        assertEquals("Shipping address created successfully.",actualResponse.getBody());
        assertEquals(HttpStatus.CREATED,actualResponse.getStatusCode());
    }

  @Test
    void createShippingAddress_WithInvalidCreateAddressCommand_returns422( ) {
        CreateShippingAddressCommand command = new CreateShippingAddressCommand();
        doThrow(new InvalidParameterException()).when(shippingService).handleCommand(command);

        ResponseEntity<String> actualResponse = shippingController.createShippingAddress(command);

        assertEquals("Could not create shipping address.",actualResponse.getBody());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY,actualResponse.getStatusCode());
    }

    @Test
    void getShippingAddressesByUser_withValidUsername_returnsAddressList() {
        String username = "userId";
        when(shippingService.handleQuery(any(ShippingAddressesByUserQuery.class)))
                .thenReturn(new ArrayList<ShippingAddressDto>(){{add(ShippingAddressDto.getInstance());}});

        List<ShippingAddressDto> shippingAddressDtos = shippingController.getShippingAddressesByUser(username);

        assertEquals(1,shippingAddressDtos.size());
    }

    @Test
    void getShippingAddressesByUser_withInvalidUsername_returnsEmptyCollection() {
        String username = "";
        when(shippingService.handleQuery(any(ShippingAddressesByUserQuery.class)))
                .thenThrow(new InvalidParameterException());

        List<ShippingAddressDto> shippingAddressDtos = shippingController.getShippingAddressesByUser(username);

        assertEquals(0,shippingAddressDtos.size());
    }
}
