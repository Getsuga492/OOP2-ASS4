package com.example.oop2a4f24.Model;

public class Animal {
    private String aName;   // Name of the animal
    private String aSex;
    private int aAge;         // Age of the animal
    private int aWeight;     // Weight of the animal (e.g., in kilograms)

    // Constructor
    public Animal(String pName, int pAge, int pWeight) {
        this.aName = pName;
        this.aAge = pAge;
        this.aWeight = pWeight;
    }

    public Animal(String pName, String pSex, int pAge, int pWeight) {
        this.aName = pName;
        this.aSex = pSex;
        this.aAge = pAge;
        this.aWeight = pWeight;
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

    public String getaSex() {
        return aSex;
    }

    public void setaSex(String pSex) {
        this.aName = pSex;
    }

    // Returns a string representation of the animal, useful for display purposes
    @Override
    public String toString() {
        return aName + " (Age: " + aAge + ", Weight: " + aWeight + " kg)";
    }
}