package ru.JD10.EmployeeBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.JD10.EmployeeBook.services.EmployeeDepartments;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartmentsController {
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



}
