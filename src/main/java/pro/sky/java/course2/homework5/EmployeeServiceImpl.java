package pro.sky.java.course2.homework5;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map <String, Employee> employees = new HashMap<> ();
@Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (getEmployees().containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            getEmployees().put(employee.getLastName(), employee);
            return employee;
        }
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (getEmployees().containsKey(employee.getLastName())) {
            getEmployees().remove(employee.getLastName());
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Employee findEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (getEmployees().containsKey(employee.getLastName())) {
            return getEmployees().get(employee.getLastName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public String printAllEmployees() {
        return Collections.unmodifiableCollection(getEmployees().values()).toString();
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }

}
