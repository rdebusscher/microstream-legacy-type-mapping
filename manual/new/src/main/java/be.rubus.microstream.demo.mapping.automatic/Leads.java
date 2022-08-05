package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.collections.HashTable;
import one.microstream.collections.types.XGettingTable;
import one.microstream.persistence.types.PersistenceRefactoringMapping;
import one.microstream.persistence.types.PersistenceRefactoringMappingProvider;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageFoundation;
import one.microstream.storage.types.StorageManager;
import one.microstream.typing.KeyValue;

import java.nio.file.Paths;

public class Leads {

    public static void main(String[] args) {

        try (StorageManager storageManager = createFoundation().start()) {

            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'old-Contacts' program first, no data in storage.");
            }

            System.out.println("Contents of the storage - Leads");
            root.getLeads().forEach(System.out::println);
        }

    }

    private static EmbeddedStorageFoundation<?> createFoundation() {
        EmbeddedStorageFoundation<?> foundation = EmbeddedStorage.Foundation(Paths.get("data"));

        // Or reading from a CSV file
        //foundation.onConnectionFoundation(f -> f.setRefactoringMappingProvider(Persistence.RefactoringMapping(Paths.get("refactorings.csv"))));
        PersistenceRefactoringMappingProvider mappingProvider = new CustomMapping();
        foundation.onConnectionFoundation(f -> f.setRefactoringMappingProvider(mappingProvider));
        return foundation;

    }

    private static class CustomMapping implements PersistenceRefactoringMappingProvider {
        @Override
        public PersistenceRefactoringMapping provideRefactoringMapping() {
            KeyValue<String, String> mapping = KeyValue.New("be.rubus.microstream.demo.mapping.automatic.Contact", "be.rubus.microstream.demo.mapping.automatic.Lead");
            // Use fields mappings using the following notation (CSV format example)
            //  Foo#oldField;Bar#newField

            XGettingTable<String, String> mappings =
                    HashTable.New(mapping);

            return PersistenceRefactoringMapping.New(mappings);

        }
    }
}
