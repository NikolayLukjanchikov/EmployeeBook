package ru.JD10.EmployeeBook.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.JD10.EmployeeBook.exceptions.EmployeeAlreadyAddedException;
import ru.JD10.EmployeeBook.exceptions.EmployeeNotFoundException;
import ru.JD10.EmployeeBook.exceptions.IncorrectSymbolsException;
import ru.JD10.EmployeeBook.model.Employee;


import static org.junit.jupiter.api.Assertions.*;
import static ru.JD10.EmployeeBook.constants.EmployeeServiceTestConstants.*;

class EmployeeServiceTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();


    @BeforeEach
    void createTestRepo() {
        out.addNewEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT);
    }

    @Test
    void shouldReturnNewAddedEmployeeAndExceptionAlreadyAddedWhenAddingSameEmployee() {
        Employee result = out.addNewEmployee(FIRST_NAME_2, LAST_NAME, SALARY, DEPARTMENT);
        assertEquals(PETR, result);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addNewEmployee(FIRST_NAME_2, LAST_NAME, SALARY, DEPARTMENT));
    }

    @Test
    void shouldReturnDeletedEmployeeAndExceptionEmployeeNotFoundWhenNothingToDelete() {
        Employee result = out.deleteEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(IVAN, result);
        assertThrows(EmployeeNotFoundException.class, () -> out.deleteEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    void shouldReturnFoundEmployeeAndExceptionEmployeeNotFoundWhenNothingToFind() {
        Employee result = out.findEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(IVAN, result);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME_2, LAST_NAME));
    }

    @Test
    void shouldReturnCapitalizeStringAndExceptionIncorrectSymbolsWhenNotLettersInString() {
        String result = out.checkNamesString(LOVER_STRING);
        assertEquals(FIRST_NAME, result);
        assertThrows(IncorrectSymbolsException.class, () -> out.checkNamesString(INCORRECT_STRING));
    }
}