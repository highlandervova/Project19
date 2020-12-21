package main;

import java.io.Serializable;
import java.util.Objects;

public class Director implements Serializable {
    private String name;
    private int    age;

    public Director() {
    }

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return age == director.age &&
                name.equals(director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
