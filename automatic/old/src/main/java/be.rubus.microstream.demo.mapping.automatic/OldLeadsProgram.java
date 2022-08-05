package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class OldLeadsProgram {

    public static void main(String[] args) {

        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {

            Root root = (Root) storageManager.root();
            if (root == null) {

                root = new Root(storageManager);
                storageManager.setRoot(root);
                storageManager.storeRoot();

                initLeads(root);
            }

            System.out.println("Contents of the storage - Old Program");
            root.getLeads().forEach(System.out::println);
        }

    }

    private static void initLeads(Root root) {

        root.addLead(
                new LeadBuilder()
                        .withName("Markus Kett")
                        .withEmail("m.kett@microstream.one")
                        .withQuality(5)
                        .withNote("Spoke with him at the conference")
                        .withReference("DroidCon Berlin")
                        .build()
        );
        root.addLead(
                new LeadBuilder()
                        .withName("Rudy De Busscher")
                        .withEmail("r.debusscher@microstream.one")
                        .withQuality(4)
                        .withNote("Spoke with him at the evening Event")
                        .withReference("Java Forum Stuttgart")
                        .build()
        );

    }
}
