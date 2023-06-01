package pro.sky.java.course2.homework5;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryPerDep(int department);

    Employee findEmployeeWithMinSalaryPerDep(int department);

    String printAllEmployeesPerDep(int department);

    String printAll();
}
