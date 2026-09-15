package in.ggklass.AOPDemo.controller;

import in.ggklass.AOPDemo.dto.Student;
import in.ggklass.AOPDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/students")
@RestController
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }
}