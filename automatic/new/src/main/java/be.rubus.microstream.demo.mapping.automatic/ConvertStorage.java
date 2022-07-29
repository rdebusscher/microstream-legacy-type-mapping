package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.persistence.types.Storer;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class ConvertStorage {

    public static void main(String[] args) {

        // Initialize a storage manager ("the database") with the given directory and defaults for everything else.
        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {


            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'old-Leads' program first, no data in storage.");
            }
            Storer eagerStorer = storageManager.createEagerStorer();
            eagerStorer.store(root);  // Does not write to target.
            eagerStorer.commit();  // This does the save to storage.

            //eagerStorer.store(root.getLeads());  // If you only want to convert the affected instances and recommended for larger datasets.

            System.out.println("Converted storage to new Lead class format");

        }

    }
}
