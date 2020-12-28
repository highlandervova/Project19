package main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@XmlRootElement(name = "department")
public class Department implements Serializable {
    @XmlAttribute(name = "id")
    public int    id;
    @XmlAttribute(name = "name")
    public String name;
    @XmlElement(name = "location")
    public String location;
    @XmlElement(name = "employee")
    @XmlElementWrapper(name = "employees")
    public Collection<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(int id, String name, String location, Collection<Employee> employees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.employees = employees;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

//    public Collection<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Collection<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                name.equals(that.name) &&
                location.equals(that.location) &&
                employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, employees);
    }
}
