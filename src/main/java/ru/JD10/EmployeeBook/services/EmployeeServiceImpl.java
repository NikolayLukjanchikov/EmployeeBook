package ru.JD10.EmployeeBook.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.JD10.EmployeeBook.exceptions.EmployeeAlreadyAddedException;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;
import ru.JD10.EmployeeBook.exceptions.IncorrectSymbolsException;
import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee addNewEmployee(String firstName, String lastName, int salary, int department) {
        Employee newEmployeeToAdd = new Employee(checkNamesString(firstName), checkNamesString(lastName), salary, department);
        if (employees.containsKey(newEmployeeToAdd.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(newEmployeeToAdd.getFullName(), newEmployeeToAdd);
        }
        return newEmployeeToAdd;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employeeToDelete = new Employee(checkNamesString(firstName), checkNamesString(lastName));
        if (employees.containsKey(employeeToDelete.getFullName())) {
            return employees.remove(employeeToDelete.getFullName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(checkNamesString(firstName), checkNamesString(lastName));
        if (employees.containsKey(employeeToFind.getFullName())) {
            return employees.get(employeeToFind.getFullName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public String checkNamesString(String stringToCheck) {
        if (StringUtils.isAlpha(stringToCheck)) {
            return StringUtils.capitalize(stringToCheck);
        } else {
            throw new IncorrectSymbolsException();
        }
    }
}
