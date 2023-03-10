package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;

    private String city;

    private String county;

    private String zipCode;

    public Address(){

    }

    public Address(String street, String city, String county, String zipCode) {
        this.street = street;
        this.city = city;
        this.county = county;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
