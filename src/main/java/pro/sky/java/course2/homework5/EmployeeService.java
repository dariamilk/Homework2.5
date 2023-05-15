package pro.sky.java.course2.homework5;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee removeEmployee(String firstName, String lastName, int department, double salary);

    Employee findEmployee(String firstName, String lastName, int department, double salary);

    String printAllEmployees();
}
