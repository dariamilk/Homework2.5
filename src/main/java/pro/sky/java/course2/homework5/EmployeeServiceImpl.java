package pro.sky.java.course2.homework5;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map <String, Employee> employees = new HashMap<> ();
@Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getLastName(), employee);
            return employee;
        }
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getLastName())) {
            employees.remove(employee.getLastName());
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getLastName())) {
            return employees.get(employee.getLastName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public String printAllEmployees() {
        return Collections.unmodifiableCollection(employees.values()).toString();
    }
}
