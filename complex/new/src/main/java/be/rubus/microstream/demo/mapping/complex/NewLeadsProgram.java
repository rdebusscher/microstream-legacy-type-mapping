package be.rubus.microstream.demo.mapping.complex;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageFoundation;
import one.microstream.storage.types.StorageManager;

import java.io.File;

public class NewLeadsProgram {

    public static void main(String[] args) {

        try (StorageManager storageManager = createFoundation().start()) {

            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'oldLeadsProgram' program first, no data in storage.");
            }

            System.out.println("Contents of the storage");
            root.getLeads().forEach(System.out::println);
        }

    }

    private static EmbeddedStorageFoundation<?> createFoundation() {
        return EmbeddedStorage.Foundation(new File("data").toPath())
                .onConnectionFoundation(f ->
                        f.getCustomTypeHandlerRegistry()
                                .registerLegacyTypeHandler(new LeadLegacyHandler()));
    }

}
