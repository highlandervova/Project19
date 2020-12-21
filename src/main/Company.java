package main;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class Company implements Serializable {
    private String name;
    private Director director;
    private Collection<Department> departments;

    public Company() {
    }

    public Company(String name, Director director, Collection<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", departments=" + departments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name) &&
                director.equals(company.director) &&
                departments.equals(company.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, departments);
    }
}
