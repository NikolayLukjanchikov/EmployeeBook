package ru.JD10.EmployeeBook.services;


import org.springframework.stereotype.Service;
import ru.JD10.EmployeeBook.model.Employee;
import ru.JD10.EmployeeBook.exceptions.EmployeeAlreadyAddedException;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final List<Employee> employees = new ArrayList<>();


    public Employee addNewEmployee(String firstName, String lastName) {
        Employee newEmployeeToAdd = new Employee(firstName, lastName);
        if (employees.contains(newEmployeeToAdd)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(newEmployeeToAdd);
        }
        return employees.get((employees.size() - 1));
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employeeToDelete = new Employee(firstName, lastName);
        if (employees.contains(employeeToDelete)) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).equals(employeeToDelete)) {
                    employeeToDelete = employees.get(i);
                    employees.remove(employees.get(i));
                    return employeeToDelete;
                }
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employees.contains(employeeToFind)) {
            for (int i = 0; i < employees.size(); i++) {
                return employees.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List printAllEmployees() {
        return employees;
    }
}
