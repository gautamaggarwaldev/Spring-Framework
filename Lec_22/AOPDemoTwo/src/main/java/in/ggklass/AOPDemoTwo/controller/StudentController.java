package in.ggklass.AOPDemoTwo.controller;

import in.ggklass.AOPDemoTwo.dto.Student;
import in.ggklass.AOPDemoTwo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentRes = studentService.createStudent(student);
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = studentService.dummyMethod("garima");
        return ResponseEntity.ok(s);
    }
}
