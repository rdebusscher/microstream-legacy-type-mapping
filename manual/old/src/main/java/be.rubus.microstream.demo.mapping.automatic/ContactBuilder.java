package be.rubus.microstream.demo.mapping.automatic;

public class ContactBuilder {
    private String name;
    private String email;
    private String note;
    private String postalCode;
    private String city;

    public ContactBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public ContactBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public ContactBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public ContactBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public Contact build() {
        return new Contact(name, email, note, postalCode, city);
    }
}