package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class UpdateSingleLead {

    public static void main(String[] args) {

        // Initialize a storage manager ("the database") with the given directory and defaults for everything else.
        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {


            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'old-Leads' program first, no data in storage.");
            }

            root.updateNote("r.debusscher@microstream.one", "new note content");
            System.out.println("Update note for Rudy");
            System.out.println("You can still run 'old-Leads' and 'new-ShowLeads'");
        }

    }
}
