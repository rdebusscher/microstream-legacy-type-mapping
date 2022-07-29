# MicroStream Legacy Type Mapping

Examples of the Legacy Type Mapping of MicroStream

## Automatic mapping

The MicroStream engine can handle 'small' changes automatically. No action is required from the developer when your data model has small changes.  What are 'small' changes?

- Rename a property within a class.
- Add a new property
- Removal of a property.

Within the _automatic_ directory there is an example that you can use to play with this automatic Legacy Type Mapping feature.

The Root object contains a `List<Lead>` collection that keeps the data for our application.  In the _old_ version of the program, the structure of the `Lead` class is

---
private String name;
private int quality;
private String email;
private String note;
private String reference;
---

With the class `Leads` you can fill your data target with a few entries and you can print out the contents of it.  Run this program to get started with this example.

In a second version of the program, you realise

- The field _reference_ was not really useful as people use _note- for this anyway.
- You rename the property _name_ to _contactName_
- You reorder the fields since it makes more sense that the _email_ field is the first.

The code is available in the _new_ module of the project.  You can run the `ShowLeads` class to show the contents of the storage we created with the _old_ version of the program.  Since we only made some _small_ changes, MicroStream has no problem reading the data and showing the List of _Leads_.

You also notice in the log that it mentions that an automatic Legacy Type Mapping is generated for the second version of our class. The _Type Dictionary_ of the storage can contain multiple versions of the same class with its respective layout of the properties.

If we only read the storage, the data is converted into the new layout into memory (the JVM heap) but the storage contains still the data in the old format.  So if we run the `Leads` program in the _old_ module again, we see that all data is still there, including the value of the _reference_ field.

If we change an instance and store it to the storage target, the layout will be the one of the _new_ program.  The update is performed by running the class `UpdateSingleLead`.  We can verify if the update was successful by running the `ShowLeads` program from the _new_ module. But also the old program can still read the data. It detects the new layout of the class and automatically maps it to the old format. This means that for the updated item of the _Lead_ List, the _reference_ field is null now as you can see if you run the `Lead`  program.

So, MicroStream can handle multiple versions of a class at the same time in the storage target. And it will convert it to the layout of the class it is running for the moment. As long as they are _small_ changes. In the next example, we will see how you as a developer can define the mapping for a larger-scale refactoring or change.

But how can you convert your entire database to make use of the new layout, and don't wait until an instance has been changed?  This can be done by forcing storage of all items which will use the new format.  The easiest way to perform this task is to use an `EagerStorer`.

---
Storer eagerStorer = storageManager.createEagerStorer();
eagerStorer.store(root.getLeads());  // Does not write to target.
eagerStorer.commit();  // This does the save to storage.
---

This is done by the program `ConvertStorage` that is available in the _new_ module.

From now on, the `ShowLeads` program does not mention mapping anymore because no data in another format is available than the one the program itself uses. But the old program `Leads` is still able to read the data, just as we did before.
