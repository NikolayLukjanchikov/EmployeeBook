package ru.JD10.EmployeeBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;
import ru.JD10.EmployeeBook.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxSalaryEmployee(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minSalaryEmployeeInDept(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getEmployeesFromDepartment(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentNumber() == department)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<Employee> getEmployeesByDepartmentsOrder() {
        return employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentNumber))
                .collect(Collectors.toUnmodifiableList());
    }
}
