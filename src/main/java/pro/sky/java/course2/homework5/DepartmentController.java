package pro.sky.java.course2.homework5;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
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

    @GetMapping ("{id}/salary/max")
    public double findMaxSalaryPerDep (@PathVariable int id) {
        return departmentService.findMaxSalaryPerDep(id);
    }

    @GetMapping ("{id}/salary/min")
    public double findMinSalaryPerDep (@PathVariable int id) {
        return departmentService.findMinSalaryPerDep(id);
    }

    @GetMapping ("{id}/salary/sum")
    public double findSalarySumPerDep (@PathVariable int id) {
        return departmentService.findSalarySumPerDep(id);
    }

    @GetMapping("/{id}/employees")
    public String printAllEmployeesPerDep (@PathVariable ("id") int id) {
        return departmentService.printAllEmployeesPerDep(id);
    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> printAllEmployees () {
        return departmentService.printAll();
    }
}
