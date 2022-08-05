package be.rubus.microstream.demo.mapping.automatic;

import java.util.StringJoiner;

public class Lead {

    private final String email;
    private String contactName;  // renamed
    private int quality;
    private String note;

    // Removed : property reference

    public Lead(String contactName, int quality, String email, String note) {
        this.contactName = contactName;
        this.quality = quality;
        this.email = email;
        this.note = note;
    }

    public String getContactName() {
        return contactName;
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

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lead.class.getSimpleName() + "[", "]")
                .add("name='" + contactName + "'")
                .add("quality=" + quality)
                .add("email='" + email + "'")
                .add("note='" + note + "'")
                .toString();
    }
}
