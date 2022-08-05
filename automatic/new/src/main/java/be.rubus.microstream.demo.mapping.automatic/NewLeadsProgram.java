package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class NewLeadsProgram {

    public static void main(String[] args) {

        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {

            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'OldLeadsProgram' program first, no data in storage.");
            }

            System.out.println("Contents of the storage - New Program");
            root.getLeads().forEach(System.out::println);
        }

    }
}
