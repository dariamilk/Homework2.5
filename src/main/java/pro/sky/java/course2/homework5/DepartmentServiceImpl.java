package pro.sky.java.course2.homework5;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;
    public DepartmentServiceImpl (EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee findEmployeeWithMaxSalaryPerDep (int department) {
       return employeeService.getEmployees().values().stream()
               .filter(e -> e.getDepartment() == department)
               .max(Comparator.comparingDouble(e -> e.getSalary()))
               .orElseThrow(() -> new EmployeeNotFoundException());
    }
    @Override
    public Employee findEmployeeWithMinSalaryPerDep (int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }
    @Override
    public String printAllEmployeesPerDep (int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toUnmodifiableList()).toString();
    }
    @Override
    public String printAll () {
        return employeeService.getEmployees()
                .values()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()).
                toString();
    }

}
