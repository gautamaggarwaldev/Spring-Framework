package in.ggklass.JPARelationships.controller;


import in.ggklass.JPARelationships.model.Department;
import in.ggklass.JPARelationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Department created");
    }

    @PostMapping("/student")
    public ResponseEntity<String> createDepartment(@RequestBody Department department,
                                                   @RequestParam String studentName) {
        departmentService.createDepartment(department, studentName);
        return ResponseEntity.ok("Department created");
    }
}
