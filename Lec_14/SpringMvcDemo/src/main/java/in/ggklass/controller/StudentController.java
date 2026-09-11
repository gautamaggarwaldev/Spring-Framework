package in.ggklass.controller;

import in.ggklass.entity.Student;
import in.ggklass.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq) {
        Student studentRes = studentService.createStudent(studentReq);
        if(studentRes==null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id) {
        Student studentRes = studentService.findStudentById(id);

        if(studentRes==null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.findAllStudent();

        if(students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }
}
