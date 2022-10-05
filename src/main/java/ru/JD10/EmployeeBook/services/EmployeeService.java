package ru.JD10.EmployeeBook.services;


import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface EmployeeService {
    Employee addNewEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> printAllEmployees();
}
