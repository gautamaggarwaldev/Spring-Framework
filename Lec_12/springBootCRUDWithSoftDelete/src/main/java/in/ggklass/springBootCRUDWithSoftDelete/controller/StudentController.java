package in.ggklass.springBootCRUDWithSoftDelete.controller;


import in.ggklass.springBootCRUDWithSoftDelete.entity.Student;
import in.ggklass.springBootCRUDWithSoftDelete.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    1. create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //    2. read one student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
        Student studentRes = studentService.getStudent(id);
        if(studentRes==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentRes);
    }

    //    3. get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentlist = studentService.getAllStudents();
        if(studentlist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentlist);

    }

    //    4. update student
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student studentReq) {
        Student studentRes = studentService.updateStudent(id, studentReq);
        if(studentRes==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentRes);
    }

    //    5. delete a student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }

//    6. soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id) {
        Boolean isDeleted = studentService.softDeleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}