package ru.JD10.EmployeeBook.services;


import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;


public interface EmployeeService {
    Employee addNewEmployee(String firstName, String lastName, int salary, int department);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}
