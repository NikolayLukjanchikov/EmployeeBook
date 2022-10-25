package ru.JD10.EmployeeBook.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;
import ru.JD10.EmployeeBook.model.Employee;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.JD10.EmployeeBook.constants.Constants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentsServiceTest {
    @Mock
    private EmployeeService employeeServiceMock;
    @InjectMocks
    private DepartmentsServiceImpl out;

    @BeforeEach
    void createTestRepo() {
        List<Employee> employees = List.of(
                new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_2),
                new Employee(FIRST_NAME_2, LAST_NAME, SALARY_2, DEPARTMENT_2),
                new Employee(LAST_NAME, LAST_NAME, SALARY, DEPARTMENT_1)
        );
        when(employeeServiceMock.getAllEmployees()).thenReturn(employees);
    }

    @Test
    void shouldReturnEmployeeWithMaxSalaryFromCurrentDepartmentWhenDepartmentNumberIsCorrect() {
        assertThat(out.maxSalaryEmployeeInDept(DEPARTMENT_2)).isEqualTo(IVAN);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalaryEmployeeInDept(DEPARTMENT_INCORRECT));
    }

    @Test
    void shouldReturnEmployeeWithMinSalaryFromCurrentDepartmentWhenDepartmentNumberIsCorrect() {
        assertThat(out.minSalaryEmployeeInDept(DEPARTMENT_2)).isEqualTo(PETR);
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalaryEmployeeInDept(DEPARTMENT_INCORRECT));
    }

    @Test
    void shouldReturnAllEmployeesFromCurrentDepartment() {
        assertThat(out.getEmployeesFromDepartment(DEPARTMENT_2)).isEqualTo(List.of(
                new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_2),
                new Employee(FIRST_NAME_2, LAST_NAME, SALARY_2, DEPARTMENT_2))
        );
    }

    @Test
    void shouldReturnAllEmployeesSortByDepartment() {
        assertThat(out.getEmployeesByDepartmentsOrder()).isEqualTo(List.of(
                new Employee(LAST_NAME, LAST_NAME, SALARY, DEPARTMENT_1),
                new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_2),
                new Employee(FIRST_NAME_2, LAST_NAME, SALARY_2, DEPARTMENT_2))
        );
    }
}