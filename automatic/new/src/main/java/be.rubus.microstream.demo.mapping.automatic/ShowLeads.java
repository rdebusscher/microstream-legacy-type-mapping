package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class ShowLeads {

    public static void main(String[] args) {

        // Initialize a storage manager ("the database") with the given directory and defaults for everything else.
        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {


            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'old-Leads' program first, no data in storage.");
            }

            System.out.println("Contents of the storage");
            root.getLeads().forEach(System.out::println);
        }

    }
}