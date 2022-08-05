package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.persistence.types.Persister;

import java.util.ArrayList;
import java.util.List;

public class Root {

    // Automatically set by MicroStream when Root is read from Storage
    private transient Persister persister;

    private final List<Lead> leads = new ArrayList<>();

    public List<Lead> getLeads() {
        return leads;
    }
}
