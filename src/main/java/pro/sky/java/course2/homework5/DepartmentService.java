package pro.sky.java.course2.homework5;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryPerDep(int department);

    Employee findEmployeeWithMinSalaryPerDep(int department);

    String printAllEmployeesPerDep(int department);

    Map<Integer, List<Employee>> printAll();

    double findMaxSalaryPerDep(int id);

    double findMinSalaryPerDep(int id);

    double findSalarySumPerDep(int id);
}
