package com.example.oop2a4f24.Model;

public class Animal {
    private String name;
    private String sex;
    private int age;
    private double weight;

    public Animal(String name, String sex, int age, double weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}