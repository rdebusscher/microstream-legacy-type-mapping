package be.rubus.microstream.demo.mapping.complex;

import one.microstream.persistence.types.Persister;

import java.util.ArrayList;
import java.util.List;

public class Root {

    private final transient Persister persister;

    private final List<Lead> leads = new ArrayList<>();

    public Root(Persister persister) {
        this.persister = persister;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void addLead(Lead lead) {
        leads.add(lead);
        persister.store(leads);
    }
}
