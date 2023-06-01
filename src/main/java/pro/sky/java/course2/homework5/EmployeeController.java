package pro.sky.java.course2.homework5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;
    public EmployeeController (EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }
    @GetMapping("/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                 @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeServiceImpl.addEmployee(firstName, lastName, department, salary);
    }
    @GetMapping("/remove")
    public Employee removeEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                    @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeServiceImpl.removeEmployee(firstName, lastName, department, salary);
    }
    @GetMapping("/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                  @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return employeeServiceImpl.findEmployee(firstName, lastName, department, salary);
    }
    @GetMapping("/print")
    public String printAllEmployees () {
        return employeeServiceImpl.printAllEmployees();
    }

}
