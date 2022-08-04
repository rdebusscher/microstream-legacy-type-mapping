package be.rubus.microstream.demo.mapping.complex;

import java.util.StringJoiner;

public class Lead {

    private String email;
    private String contactName;
    private int quality;
    private String note;

    private Address address;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Lead.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("contactName='" + contactName + "'")
                .add("quality=" + quality)
                .add("note='" + note + "'")
                .add("address='" + address + "'")
                .toString();
    }
}
