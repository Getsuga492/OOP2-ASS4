package com.example.oop2a4f24.Model;

public abstract class Animal {
    private String aName;     // Name of the animal
    private int aAge;         // Age of the animal
    private int aWeight;     // Weight of the animal (e.g., in kilograms)

    // Constructor
    public Animal(String name, int age, int weight) {
        this.aName = name;
        this.aAge = age;
        this.aWeight = weight;
    }

    // Getter and Setter for name
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    // Getter and Setter for age
    public int getaAge() {
        return aAge;
    }

    public void setaAge(int aAge) {
        this.aAge = aAge;
    }

    // Getter and Setter for weight
    public int getaWeight() {
        return aWeight;
    }

    public void setaWeight(int aWeight) {
        this.aWeight = aWeight;
    }

    // Returns a string representation of the animal, useful for display purposes
    @Override
    public String toString() {
        return aName + " (Age: " + aAge + ", Weight: " + aWeight + " kg)";
    }
}