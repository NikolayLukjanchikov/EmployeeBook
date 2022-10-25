package ru.JD10.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.JD10.EmployeeBook.model.Employee;
import ru.JD10.EmployeeBook.services.DepartmentsService;

import java.util.Collection;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/max-salary")
    private Employee maxSalaryEmployee(@RequestParam int departmentId) {
        return departmentsService.maxSalaryEmployeeInDept(departmentId);
    }

    @GetMapping("/min-salary")
    private Employee minSalaryEmployeeInDept(@RequestParam int departmentId) {
        return departmentsService.minSalaryEmployeeInDept(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    private Collection<Employee> getEmployeesFromDepartment(@RequestParam int departmentId) {
        return departmentsService.getEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/all")
    private Collection<Employee> getEmployeesByDepartmentsOrder() {
        return departmentsService.getEmployeesByDepartmentsOrder();
    }

}
