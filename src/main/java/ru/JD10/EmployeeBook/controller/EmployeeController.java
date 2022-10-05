package ru.JD10.EmployeeBook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.JD10.EmployeeBook.model.Employee;
import ru.JD10.EmployeeBook.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    private Employee addNewEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addNewEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    private Employee deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    private Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/printall")
    private List printAllEmployees() {
        return employeeService.printAllEmployees();
    }

}