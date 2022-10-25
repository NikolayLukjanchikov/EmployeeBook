package ru.JD10.EmployeeBook.constants;

import ru.JD10.EmployeeBook.model.Employee;

public class Constants {
    public static final String FIRST_NAME = "Ivan";
    public static final String FIRST_NAME_2 = "Petr";
    public static final String LAST_NAME = "Petrov";
    public static final String LOWER_STRING = "ivan";
    public static final String INCORRECT_STRING = "iv0n";
    public static final int SALARY = 8888;
    public static final int SALARY_2 = 2222;
    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;
    public static final int DEPARTMENT_INCORRECT = 3;
    public static final Employee IVAN = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_2);
    public static final Employee PETR = new Employee(FIRST_NAME_2, LAST_NAME, SALARY_2, DEPARTMENT_2);

}
