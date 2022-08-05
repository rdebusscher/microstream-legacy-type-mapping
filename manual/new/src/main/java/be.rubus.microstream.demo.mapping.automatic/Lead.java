package be.rubus.microstream.demo.mapping.automatic;

import java.util.StringJoiner;

public class Lead {

    private final String email;
    private String contactName;
    private int quality;
    private String note;
    private String postalCode;
    private String city;

    private Country country = Country.DEFAULT;  // For 'converted' instances this default is not applied (property is null)
    // This is because MicroStream does not use the Constructor and 'normal' Java instantiation.
    // It low level creates objects on the heap and assign data and pointers.
    // The advantage is that there are no security vulnerabilities possible like you have with the standard Java Serialization approach.

    public Lead(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lead.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("contactName='" + contactName + "'")
                .add("quality=" + quality)
                .add("note='" + note + "'")
                .add("postalCode='" + postalCode + "'")
                .add("city='" + city + "'")
                .add("country=" + country)
                .toString();
    }
}
