package pro.sky.java.course2.homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeService employeeService = new EmployeeServiceImpl();
    private Map<String, Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new HashMap<>();
    }

    @Test
    void addEmployee() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 20000);
        assertEquals(employee1, employeeService.addEmployee("Ivan", "Ivanov", 1, 20000));
        assertEquals(1, employeeService.getEmployees().size());
    }
    @Test
    void addTheSameEmployeeThrowsException() {
        assertDoesNotThrow(() ->employeeService.addEmployee("Ivan", "Ivanov", 1, 20000));
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee("Ivan", "Ivanov", 1, 20000));
    }
    @Test
    void removeEmployee() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 20000);
        employeeService.addEmployee("Ivan", "Ivanov", 1, 20000);
        assertEquals(employee1, employeeService.removeEmployee("Ivan", "Ivanov", 1, 20000));
        assertEquals(0, employeeService.getEmployees().size());
        assertTrue(employeeService.getEmployees().isEmpty());
    }

    @Test
    void findEmployee() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 20000);
        employeeService.addEmployee("Ivan", "Ivanov", 1, 20000);
        assertNotNull(employeeService.findEmployee("Ivan", "Ivanov", 1, 20000));
        assertEquals(employee1, employeeService.findEmployee("Ivan", "Ivanov", 1, 20000));
    }
    @Test
    void findEmployeeThrowsExceptionWhenEmployeeDoesNotExist() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Ivan", "Ivanov", 1, 20000));
    }

    @Test
    void printAllEmployees() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 20000);
        Employee employee2 = new Employee("Ivan", "Petrov", 2, 30000);
        employees.put(employee1.getLastName(), employee1);
        employees.put(employee2.getLastName(), employee2);
        employeeService.addEmployee("Ivan", "Ivanov", 1, 20000);
        employeeService.addEmployee("Ivan", "Petrov", 2, 30000);
        Assertions.assertNotNull(employeeService.printAllEmployees());
        Assertions.assertEquals(Collections.unmodifiableCollection(employees.values()).toString(), employeeService.printAllEmployees());
    }
    @Test
    void getEmployees() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 20000);
        Employee employee2 = new Employee("Ivan", "Petrov", 2, 30000);
        employees.put(employee1.getLastName(), employee1);
        employees.put(employee2.getLastName(), employee2);
        employeeService.addEmployee("Ivan", "Ivanov", 1, 20000);
        employeeService.addEmployee("Ivan", "Petrov", 2, 30000);
        assertEquals(employees, employeeService.getEmployees());
    }


}