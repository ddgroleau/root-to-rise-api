package com.rtr.api.application.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@Entity
@Table(name="shipping_addresses")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_address_id", nullable = false)
    private Integer shippingAddressId;

    @NotNull
    @Column(name="user_id")
    private String userId;

    @NotNull
    @Column(name="address_line1")
    private String addressLine1;

    @Column(name="address_line2")
    private String addressLine2;

    @NotNull
    @Column(name="city")
    private String city;

    @NotNull
    @Column(name="state")
    private String state;

    @NotNull
    @Column(name="zip_code", length = 10)
    private String zipCode;

    @NotNull
    @Column(name="country")
    private String country;

    @Column(name="phone_number", length = 11)
    private String phoneNumber;

    @NotNull
    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="created_by")
    private String createdBy;

    @NotNull
    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @Column(name="updated_by")
    private String updatedBy;

    public ShippingAddress() {
        setCreatedBy("ShippingAddress");
        setUpdatedBy("ShippingAddress");
        setCreatedOn(LocalDateTime.now());
        setUpdatedOn(LocalDateTime.now());
    }

    public static ShippingAddress createInstance() {
        return new ShippingAddress();
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        if(addressLine1 == null || addressLine1.isBlank()) throw new InvalidParameterException("Invalid address line 1.");
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        if(addressLine2 == null || addressLine2.isBlank()) throw new InvalidParameterException("Invalid address line 2.");
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.isBlank()) throw new InvalidParameterException("Invalid city.");
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(state == null || state.isBlank()) throw new InvalidParameterException("Invalid state.");
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode == null || zipCode.isBlank()) throw new InvalidParameterException("Invalid zip code.");
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            if(phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() != 11)
                throw new InvalidParameterException("Invalid phone number.");
            new BigInteger(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch(Exception e){
            throw new InvalidParameterException("Invalid phone number.");
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country == null || country.isBlank()) throw new InvalidParameterException("Invalid country.");
        this.country = country;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if(userId == null || userId.isBlank()) throw new InvalidParameterException("Invalid user ID.");
        this.userId = userId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
