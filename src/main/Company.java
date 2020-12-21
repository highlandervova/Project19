package main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@XmlRootElement(name = "company")
public class Company implements Serializable {
    @XmlAttribute(name = "name")
    public String name;
    @XmlElement(name = "director")
    public Director director;
    @XmlElement(name = "department")
    @XmlElementWrapper(name = "departments")
    public Collection<Department> departments = new ArrayList<>();

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
