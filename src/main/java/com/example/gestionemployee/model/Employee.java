package com.example.gestionemployee.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String role;
    private double salary;
    private String email;
    // constructors
    public Employee(){};
    public Employee(String name, String role, String email, double salary){
        this.email=email;
        this.name = name;
        this.role= role;
        this.salary = salary;
    }

    // getters and setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Employee :" +"\n" + id +"\n"+role + "\n"+ name + "\n"+ email +"\n" + salary;
    }
}

