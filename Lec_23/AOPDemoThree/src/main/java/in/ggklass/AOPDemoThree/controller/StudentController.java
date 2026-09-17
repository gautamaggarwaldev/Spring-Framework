package in.ggklass.AOPDemoThree.controller;

import in.ggklass.AOPDemoThree.dto.Student;
import in.ggklass.AOPDemoThree.service.StudentService;
import in.ggklass.AOPDemoThree.service.StudentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    private StudentServiceInterface studentService;

    public StudentController(StudentServiceInterface studentService) {
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


