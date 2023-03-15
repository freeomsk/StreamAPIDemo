package ru.freeomsk.streamapidemo.model;

import java.math.BigDecimal;

public class Specialist {
    private String name;
    private BigDecimal salary;
    private Speciality speciality;

    public Specialist(String name, BigDecimal salary, Speciality speciality) {
        this.name = name;
        this.salary = salary;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                '}';
    }
}
