package com.example.demo2;

public class Employee {
    protected Employeetype type;
    protected int id;
    protected String name;
    protected String surname;
    protected String phonenumber;
    protected String position;

    protected Double salary;



    public Employee() {}

    public Employee(Employeetype type, int id, String name, String surname, String phonenumber, String position) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.position = position;
    }

    public Employeetype getType() {
        return type;
    }

    public void setType(Employeetype type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
