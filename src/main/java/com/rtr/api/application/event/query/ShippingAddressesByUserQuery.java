package com.rtr.api.application.event.query;

public class ShippingAddressesByUserQuery implements Query {
    private String username;

    private ShippingAddressesByUserQuery(String username) {
        this.username = username;
    }

    public static ShippingAddressesByUserQuery getInstance(String username) {
        return new ShippingAddressesByUserQuery(username);
    }

    public String getUsername() {
        return username;
    }
}
