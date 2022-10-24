package ru.JD10.EmployeeBook.constants;

import ru.JD10.EmployeeBook.model.Employee;

import java.util.*;

public class EmployeeServiceTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String FIRST_NAME_2 = "Petr";
    public static final String LAST_NAME = "Petrov";
    public static final String LOVER_STRING = "ivan";
    public static final String INCORRECT_STRING = "iv0n";

    public static final int SALARY = 77777;
    public static final int DEPARTMENT = 2;
    public static final Employee IVAN = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
    public static final Employee PETR = new Employee(FIRST_NAME_2, LAST_NAME, SALARY, DEPARTMENT);
public static final Collection<Employee> employeeList = Collections.unmodifiableCollection(Set.of(IVAN));


}
