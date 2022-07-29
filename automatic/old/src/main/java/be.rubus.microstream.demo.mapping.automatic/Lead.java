package be.rubus.microstream.demo.mapping.automatic;

import java.util.StringJoiner;

public class Lead {

    private final String name;
    private final int quality;
    private final String email;
    private final String note;
    private final String reference;

    public Lead(String name, int quality, String email, String note, String reference) {
        this.name = name;
        this.quality = quality;
        this.email = email;
        this.note = note;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lead.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("quality=" + quality)
                .add("email='" + email + "'")
                .add("note='" + note + "'")
                .add("reference='" + reference + "'")
                .toString();
    }
}
