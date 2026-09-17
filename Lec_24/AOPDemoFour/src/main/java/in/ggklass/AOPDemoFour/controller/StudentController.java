package in.ggklass.AOPDemoFour.controller;

import in.ggklass.AOPDemoFour.dto.Student;
import in.ggklass.AOPDemoFour.service.StudentService;
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
    public ResponseEntity<String> getStudent() {
        String s = "All student data.";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
