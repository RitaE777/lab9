package org.example;

import java.util.Objects;

public class Human {
    private String name;
    private String surName;
    private String lastName;
    private int age;
    private Gender gender;

    public Human(String name, String surName, String lastName, int age, Gender gender) {
        this.name = name;
        this.surName = surName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name) && Objects.equals(surName, human.surName) && Objects.equals(lastName, human.lastName) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, lastName, age, gender);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}