package com.sda.rentalloapp;

import org.junit.jupiter.api.Test;

import java.util.Objects;

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

public class HashCollectionTest {

    @Test
    public void equalityTestForPersons(){
        Person maciek = new Person("maciek");
        Person maciek2 = new Person("maciek");

        boolean theSame = maciek.equals(maciek2);
        System.out.println("Is the same object?: " + theSame);
    }
}
