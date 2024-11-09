package com.example.oop2a4f24.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection {
    private String name;
    private List<Animal> animals; // Holds animals within this enclosure

    // Constructor
    public Enclosure() {
        this.animals = new ArrayList<>();
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

    // Adds an animal to the enclosure
    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Removes an animal from the enclosure
    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    // Retrieves the list of animals in the enclosure
    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    // Unsupported operations since Enclosure cannot hold other collections
    @Override
    public void addCollection(AnimalCollection collection) {
        throw new UnsupportedOperationException("Cannot add collections to an enclosure.");
    }

    @Override
    public void removeCollection(AnimalCollection collection) {
        throw new UnsupportedOperationException("Cannot remove collections from an enclosure.");
    }

    @Override
    public AnimalCollection findCollectionByName(String name) {
        throw new UnsupportedOperationException("Cannot search collections within an enclosure.");
    }
}
