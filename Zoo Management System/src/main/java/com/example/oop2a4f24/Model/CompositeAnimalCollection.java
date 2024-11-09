package com.example.oop2a4f24.Model;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimalCollection implements AnimalCollection {
    private String name;
    private List<AnimalCollection> collections; // Holds both Enclosures and nested CompositeAnimalCollections

    // Constructor
    public CompositeAnimalCollection() {
        this.collections = new ArrayList<>();
    }

    // Getter and Setter for name
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Adds a sub-collection (e.g., an Enclosure or another CompositeAnimalCollection)
    @Override
    public void addCollection(AnimalCollection collection) {
        collections.add(collection);
    }

    // Removes a sub-collection by reference
    @Override
    public void removeCollection(AnimalCollection collection) {
        collections.remove(collection);
    }

    // Finds a sub-collection by name (recursive to handle nested structures)
    @Override
    public AnimalCollection findCollectionByName(String name) {
        for (AnimalCollection collection : collections) {
            if (collection.getName().equalsIgnoreCase(name)) {
                return collection;
            } else if (collection instanceof CompositeAnimalCollection) {
                // Recursively search in nested collections
                AnimalCollection found = ((CompositeAnimalCollection) collection).findCollectionByName(name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null; // Return null if no collection with the specified name is found
    }

    // Returns all animals in this composite collection, gathering from all sub-collections
    @Override
    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        for (AnimalCollection collection : collections) {
            animals.addAll(collection.getAnimals());
        }
        return animals;
    }

    // Unsupported operation for CompositeAnimalCollection
    @Override
    public void addAnimal(Animal animal) {
        throw new UnsupportedOperationException("Cannot add animals directly to a composite collection.");
    }

    // Unsupported operation for CompositeAnimalCollection
    @Override
    public void removeAnimal(Animal animal) {
        throw new UnsupportedOperationException("Cannot remove animals directly from a composite collection.");
    }

    // Returns the list of sub-collections (e.g., enclosures or nested composites) in this composite
    public List<AnimalCollection> getCollections() {
        return collections;
    }
}
