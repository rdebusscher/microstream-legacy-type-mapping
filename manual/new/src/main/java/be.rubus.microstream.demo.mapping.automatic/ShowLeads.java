package be.rubus.microstream.demo.mapping.automatic;

import one.microstream.afs.nio.types.NioFileSystem;
import one.microstream.collections.HashTable;
import one.microstream.collections.types.XGettingTable;
import one.microstream.persistence.types.PersistenceRefactoringMapping;
import one.microstream.persistence.types.PersistenceRefactoringMappingProvider;
import one.microstream.storage.embedded.types.EmbeddedStorageFoundation;
import one.microstream.storage.types.Storage;
import one.microstream.storage.types.StorageConfiguration;
import one.microstream.storage.types.StorageManager;
import one.microstream.typing.KeyValue;

public class ShowLeads {

    public static void main(String[] args) {

        try (StorageManager storageManager = createFoundation().start()) {

            Root root = (Root) storageManager.root();
            if (root == null) {
                throw new IllegalStateException("Run the 'old-Leads' program first, no data in storage.");
            }

            System.out.println("Contents of the storage");
            root.getLeads().forEach(System.out::println);
        }

    }

    private static EmbeddedStorageFoundation createFoundation() {
        // Initialize a storage manager ("the database")
        NioFileSystem fileSystem = NioFileSystem.New();
        EmbeddedStorageFoundation<?> foundation = EmbeddedStorageFoundation.New()
                .setConfiguration(
                        StorageConfiguration.Builder()
                                .setStorageFileProvider(
                                        Storage.FileProviderBuilder(fileSystem)
                                                .setDirectory(fileSystem.ensureDirectoryPath("data"))
                                                .createFileProvider()
                                )
                                .createConfiguration()
                );


        PersistenceRefactoringMappingProvider mappingProvider = new CustomMapping();
        foundation.onConnectionFoundation(f -> f.setRefactoringMappingProvider(mappingProvider));

        return foundation;
    }

    private static class CustomMapping implements PersistenceRefactoringMappingProvider {
        @Override
        public PersistenceRefactoringMapping provideRefactoringMapping() {
            KeyValue<String, String> mapping = KeyValue.New("be.rubus.microstream.demo.mapping.automatic.Contact", "be.rubus.microstream.demo.mapping.automatic.Lead");
            // Use fields mappings using the following notation
            //  "Foo#oldField" , "Bar#newField"

            // Or reading from a CSV file
            // Persistence.RefactoringMapping(Paths.get("refactorings.csv")).provideRefactoringMapping();

            XGettingTable<String, String> mappings =
                    HashTable.New(mapping);

            return PersistenceRefactoringMapping.New(mappings);

        }
    }
}
