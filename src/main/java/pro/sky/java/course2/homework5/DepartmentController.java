package pro.sky.java.course2.homework5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
    public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryPerDep (@RequestParam ("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryPerDep(department);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryPerDep (@RequestParam ("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryPerDep(department);
    }
    @GetMapping("/all")
    public String printAllEmployeesPerDep (@RequestParam ("departmentId") int department) {
        return departmentService.printAllEmployeesPerDep(department);
    }
    @GetMapping("/print-all")
    public String printAllEmployees () {
        return departmentService.printAll();
    }
}
