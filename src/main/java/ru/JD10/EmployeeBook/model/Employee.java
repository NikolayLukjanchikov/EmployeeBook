package ru.JD10.EmployeeBook.model;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private int salary;
    private int departmentNumber;

    public Employee(String firstName, String lastName, int salary, int departmentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentNumber = departmentNumber;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return (firstName + " " + lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getFullName() {
        return (firstName + " " + lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }
}
