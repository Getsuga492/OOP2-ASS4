package com.example.oop2a4f24.Model;

public class Enclosure implements AnimalCollection {
    private String aName;

    public void setName(String pName) {
        aName = pName;
    }

    public void addAnimal(Animal pAnimal) {

    }

    public String getName() {
        return aName;
    }
}
