package com.example.demo2;
public class Permanent extends Employee {


    @Override
    public String toString() {
        return "Permanent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", type=" + type +
                ", phonenumber='" + phonenumber + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

}
