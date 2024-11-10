package com.example.oop2a4f24.Model;

import java.util.List;

public interface AnimalCollection {

    // Returns the name of the collection (e.g., "Lions", "Big Cats", etc.)
    String getName();

    // Sets the name of the collection
    void setName(String name);

    // Returns a list of animals in this collection
    // If it's an Enclosure, it would list the animals directly in that enclosure.
    // If it's a CompositeAnimalCollection, it would list animals across sub-collections.
    List<Animal> getAnimals();

    // Adds an animal to this collection (should be specific to Enclosures)
    // For CompositeAnimalCollection, this might throw an UnsupportedOperationException
    void addAnimal(Animal animal);

    // Removes an animal from this collection
    void removeAnimal(Animal animal);

    // Adds a sub-collection (specific to CompositeAnimalCollection)
    void addCollection(AnimalCollection collection);

    // Removes a sub-collection (specific to CompositeAnimalCollection)
    void removeCollection(AnimalCollection collection);

    // Retrieves a sub-collection by name (useful for nested collections like "Tigers")
    AnimalCollection findCollectionByName(String name);
}
