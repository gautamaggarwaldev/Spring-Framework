package in.ggklass.JpaRelationshipDemo.controller;

import in.ggklass.JpaRelationshipDemo.model.Department;
import in.ggklass.JpaRelationshipDemo.service.DepartmentService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.removeDepartment(id);
        return ResponseEntity.ok("Department deleted");
    }
}
