package be.rubus.microstream.demo.mapping.complex;

public class LeadBuilder {
    private String name;
    private String email;
    private String note;
    private String postalCode;
    private String city;

    public LeadBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public LeadBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public LeadBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public LeadBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public LeadBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public Lead build() {
        return new Lead(name, email, note, postalCode, city);
    }
}