package ru.JD10.EmployeeBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;
import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDepartmentsImpl implements EmployeeDepartments {
    @Autowired
    EmployeeService employeeService;

    Collection<Employee> employees = employeeService.getAllEmployees();

    //1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    //    ```java
    //    /departments/max-salary?departmentId=5
    //2.  Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    //    ```java
    //     /departments/min-salary?departmentId=5
    //3. Возвращать всех сотрудников по отделу.
    //    ```java
    //    /departments/all?departmentId=5
    //4. Возвращать всех сотрудников с разделением по отделам.
    //     /departments/all

    public Employee maxSalaryEmployee(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee minSalaryEmployeeInDept(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> getEmployeesFromDepartment(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .collect(Collectors.toUnmodifiableList());
    }

    public Collection<Employee> getEmployeesByDepartmentsOrder(int department) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentNumber))
                .collect(Collectors.toUnmodifiableList());
    }
}
