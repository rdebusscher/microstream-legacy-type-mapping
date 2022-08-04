package be.rubus.microstream.demo.mapping.complex;

import java.util.StringJoiner;

public class Address {

    private String postalCode;

    private String city;

    private String Country;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("postalCode='" + postalCode + "'")
                .add("city='" + city + "'")
                .add("Country='" + Country + "'")
                .toString();
    }
}
