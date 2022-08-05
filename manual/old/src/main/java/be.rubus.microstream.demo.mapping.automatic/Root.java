package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.persistence.types.Persister;

import java.util.ArrayList;
import java.util.List;

public class Root {

    private final transient Persister persister;

    private final List<Contact> contacts = new ArrayList<>();

    public Root(Persister persister) {
        this.persister = persister;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        persister.store(contacts);
    }
}
