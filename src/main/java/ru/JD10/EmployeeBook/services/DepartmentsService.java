package ru.JD10.EmployeeBook.services;

import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;

public interface DepartmentsService {
    Employee maxSalaryEmployee(int department);

    Employee minSalaryEmployeeInDept(int department);

    Collection<Employee> getEmployeesFromDepartment(int department);

    Collection<Employee> getEmployeesByDepartmentsOrder();

}
