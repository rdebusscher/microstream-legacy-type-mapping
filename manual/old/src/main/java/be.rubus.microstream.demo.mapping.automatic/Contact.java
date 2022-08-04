package be.rubus.microstream.demo.mapping.automatic;

import java.util.StringJoiner;

public class Contact {

    private final String name;
    private final String email;
    private final String note;

    private final String postalCode;

    private final String city;

    public Contact(String name, String email, String note, String postalCode, String city) {
        this.name = name;
        this.email = email;
        this.note = note;

        this.postalCode = postalCode;
        this.city = city;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Contact.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("note='" + note + "'")
                .add("postalCode='" + postalCode + "'")
                .add("city='" + city + "'")
                .toString();
    }
}
