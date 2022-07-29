package be.rubus.microstream.demo.mapping.automatic;

public class LeadBuilder {
    private String name;
    private int quality;
    private String email;
    private String note;
    private String reference;

    public LeadBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public LeadBuilder withQuality(int quality) {
        this.quality = quality;
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

    public LeadBuilder withReference(String reference) {
        this.reference = reference;
        return this;
    }

    public Lead build() {
        return new Lead(name, quality, email, note, reference);
    }
}