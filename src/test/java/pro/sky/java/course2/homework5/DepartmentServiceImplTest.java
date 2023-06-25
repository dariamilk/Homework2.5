package pro.sky.java.course2.homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    DepartmentServiceImpl departmentServiceImpl;
    @BeforeEach
    void setUp() {
        Map<String, Employee> employees = new HashMap<>();
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 100);
        Employee employee2 = new Employee("Ivan", "Petrov", 1, 400);
        Employee employee3 = new Employee("Oleg", "Sidorov", 2, 200);
        Employee employee4 = new Employee("Petr", "Sergeev", 2, 500);
        Employee employee5 = new Employee("Viktor", "Kurochkin", 3, 300);
        employees.put(employee1.getLastName(), employee1);
        employees.put(employee2.getLastName(), employee2);
        employees.put(employee3.getLastName(), employee3);
        employees.put(employee4.getLastName(), employee4);
        employees.put(employee5.getLastName(), employee5);
        Mockito.when(employeeServiceImpl.getEmployees()).thenReturn(employees);
    }

    @Test
    void findEmployeeWithMaxSalaryPerDep() {
        Employee employee = new Employee("Ivan", "Petrov", 1, 400);
        assertEquals(employee, departmentServiceImpl.findEmployeeWithMaxSalaryPerDep(1));
    }

    @Test
    void findEmployeeWithMinSalaryPerDep() {
        Employee employee = new Employee("Oleg", "Sidorov", 2, 200);
        assertEquals(employee, departmentServiceImpl.findEmployeeWithMinSalaryPerDep(2));
    }

    @Test
    void printAllEmployeesPerDep() {
        String expected = employeeServiceImpl.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == 1)
                .collect(Collectors.toUnmodifiableList()).toString();
        assertEquals(expected, departmentServiceImpl.printAllEmployeesPerDep(1));
    }

    @Test
    void printAll() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 100);
        Employee employee2 = new Employee("Ivan", "Petrov", 1, 400);
        Employee employee3 = new Employee("Oleg", "Sidorov", 2, 200);
        Employee employee4 = new Employee("Petr", "Sergeev", 2, 500);
        Employee employee5 = new Employee("Viktor", "Kurochkin", 3, 300);
        List<Employee> dep1 = List.of(employee1, employee2);
        List<Employee> dep2 = List.of(employee3, employee4);
        List<Employee> dep3 = List.of(employee5);
        Map<Integer, List <Employee>> expected = new HashMap<>();
        expected.put(1, dep1);
        expected.put(2, dep2);
        expected.put(3, dep3);
        assertEquals(expected.size(), departmentServiceImpl.printAll().size());
        assertEquals(expected.keySet(), departmentServiceImpl.printAll().keySet());
    }

    @Test
    void findMaxSalaryPerDep() {
        assertEquals(500, departmentServiceImpl.findMaxSalaryPerDep(2));
    }

    @Test
    void findMinSalaryPerDep() {
        assertEquals(100, departmentServiceImpl.findMinSalaryPerDep(1));
    }

    @Test
    void findSalarySumPerDep() {
        assertEquals(700, departmentServiceImpl.findSalarySumPerDep(2));
    }
}