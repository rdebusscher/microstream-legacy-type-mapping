package be.rubus.microstream.demo.mapping.complex;

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

                System.out.println("Adding some default leads");
                initLeads(root);
            }

            System.out.println("Contents of the storage");
            root.getLeads().forEach(System.out::println);
        }

    }

    private static void initLeads(Root root) {

        root.addLead(
                new LeadBuilder()
                        .withName("Markus Kett")
                        .withEmail("m.kett@microstream.one")
                        .withNote("Spoke with him at the conference")
                        .withPostalCode("D-93053")
                        .withCity("Regensburg")
                        .build()
        );
        root.addLead(
                new LeadBuilder()
                        .withName("Rudy De Busscher")
                        .withEmail("r.debusscher@microstream.one")
                        .withNote("Spoke with him at the evening Event")
                        .withPostalCode("B-2800")
                        .withCity("Mechelen")
                        .build()
        );

    }
}
