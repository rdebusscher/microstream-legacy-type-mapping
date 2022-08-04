package be.rubus.microstream.demo.mapping.complex;

import one.microstream.X;
import one.microstream.persistence.binary.types.Binary;
import one.microstream.persistence.binary.types.BinaryLegacyTypeHandler;
import one.microstream.persistence.types.PersistenceLoadHandler;
import one.microstream.persistence.types.PersistenceReferenceLoader;

public class LeadLegacyHandler extends BinaryLegacyTypeHandler.AbstractCustom<Lead> {

    private static final long BINARY_OFFSET_name = 0;
    private static final long BINARY_OFFSET_email = BINARY_OFFSET_name + Binary.objectIdByteLength();
    private static final long BINARY_OFFSET_note = BINARY_OFFSET_email + Binary.objectIdByteLength();
    private static final long BINARY_OFFSET_postalCode = BINARY_OFFSET_note + Binary.objectIdByteLength();
    private static final long BINARY_OFFSET_city = BINARY_OFFSET_postalCode + Binary.objectIdByteLength();


    protected LeadLegacyHandler() {
        // Fields of the legacy Class. They need to match as otherwise the automatic Legacy type kicks in and
        // this handler is ignored.
        super(Lead.class,
                X.List(CustomField(String.class, "name"),
                        CustomField(String.class, "email"),
                        CustomField(String.class, "note"),
                        CustomField(String.class, "postalCode"),
                        CustomField(String.class, "city")
                ));
    }

    @Override
    public void iterateLoadableReferences(Binary data, PersistenceReferenceLoader iterator) {
        iterator.acceptObjectId(data.read_long(BINARY_OFFSET_name));
        iterator.acceptObjectId(data.read_long(BINARY_OFFSET_email));
        iterator.acceptObjectId(data.read_long(BINARY_OFFSET_note));
        iterator.acceptObjectId(data.read_long(BINARY_OFFSET_postalCode));
        iterator.acceptObjectId(data.read_long(BINARY_OFFSET_city));
    }

    @Override
    public Lead create(Binary data, PersistenceLoadHandler handler) {
        return new Lead();
    }

    @Override
    public void updateState(Binary data, Lead instance, PersistenceLoadHandler handler) {
        String name = (String) handler.lookupObject(data.read_long(BINARY_OFFSET_name));
        String email = (String) handler.lookupObject(data.read_long(BINARY_OFFSET_name));
        String note = (String) handler.lookupObject(data.read_long(BINARY_OFFSET_name));
        String postalCode = (String) handler.lookupObject(data.read_long(BINARY_OFFSET_name));
        String city = (String) handler.lookupObject(data.read_long(BINARY_OFFSET_name));

        instance.setContactName(name);
        instance.setEmail(email);
        instance.setNote(note);
        Address address = new Address();
        address.setPostalCode(postalCode);
        address.setCity(city);
        instance.setAddress(address);
    }

    @Override
    public boolean hasPersistedReferences() {
        return true;
    }

    @Override
    public boolean hasVaryingPersistedLengthInstances() {
        return false;
    }
}
