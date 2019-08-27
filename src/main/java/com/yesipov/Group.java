package com.yesipov;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public String toString() {
        return "GroupName{" +
                "name='" + name + '\'' +
                ", persons=" + persons +
                '}';
    }
}
