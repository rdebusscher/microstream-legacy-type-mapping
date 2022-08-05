package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.types.StorageManager;

import java.nio.file.Paths;

public class Contacts {

    public static void main(String[] args) {

        try (StorageManager storageManager = EmbeddedStorage.start(Paths.get("data"))) {

            Root root = (Root) storageManager.root();
            if (root == null) {

                root = new Root(storageManager);
                storageManager.setRoot(root);
                storageManager.storeRoot();

                initContacts(root);
            }

            System.out.println("Contents of the storage - Contacts");
            root.getContacts().forEach(System.out::println);
        }

    }

    private static void initContacts(Root root) {

        root.addContact(
                new ContactBuilder()
                        .withName("Markus Kett")
                        .withEmail("m.kett@microstream.one")
                        .withNote("Spoke with him at the conference")
                        .withPostalCode("D-93053")
                        .withCity("Regensburg")
                        .build()
        );
        root.addContact(
                new ContactBuilder()
                        .withName("Rudy De Busscher")
                        .withEmail("r.debusscher@microstream.one")
                        .withNote("Spoke with him at the evening Event")
                        .withPostalCode("B-2800")
                        .withCity("Mechelen")
                        .build()
        );

    }
}
