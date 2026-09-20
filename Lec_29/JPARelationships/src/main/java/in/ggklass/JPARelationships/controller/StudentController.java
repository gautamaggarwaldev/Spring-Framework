package in.ggklass.JPARelationships.controller;


import in.ggklass.JPARelationships.model.Student;
import in.ggklass.JPARelationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @PathVariable Long deptId) {
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Student created");
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam String deptName) {
        studentService.createStudent(student, deptName);
        return ResponseEntity.ok("Student created");
    }
}
