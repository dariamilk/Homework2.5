package pro.sky.java.course2.homework5;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    public String printAllEmployeesPerDep (int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toUnmodifiableList()).toString();
    }
    @Override
    public Map<Integer, List<Employee>> printAll () {
        return employeeService.getEmployees()
                .values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
    @Override
    public double findMaxSalaryPerDep(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToDouble(e -> e.getSalary())
                .max().orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public double findMinSalaryPerDep(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToDouble(e -> e.getSalary())
                .min().orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public double findSalarySumPerDep(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToDouble(e -> e.getSalary())
                .sum();
    }

}
