package pro.sky.java.course2.homework5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAXEMPLOYEENUMBER = 50;
    public List<Employee> employees = new ArrayList<>(List.of(
            new Employee ("Ольга", "Петрова"),
            new Employee("Иван", "Иванов"),
            new Employee("Сергей", "Алексеев")
            ));
@Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < MAXEMPLOYEENUMBER) {
            if (!employees.contains(employee)) {
                employees.add(employee);
                return employee;
            } else {
                throw new EmployeeAlreadyAddedException();
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public String printAllEmployees() {
        return employees.toString();
    }
}
