package in.ggklass.CrudDTODemo.controller;


import in.ggklass.CrudDTODemo.dto.CreateStudentRequestDto;
import in.ggklass.CrudDTODemo.dto.CreateStudentResponseDto;
import in.ggklass.CrudDTODemo.dto.UpdateStudentRequestDto;
import in.ggklass.CrudDTODemo.dto.UpdateStudentResponseDto;
import in.ggklass.CrudDTODemo.entity.Student;
import in.ggklass.CrudDTODemo.service.StudentService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto studentRequestDto) {
        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //    2. read one student
    @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@RequestParam Long id) {
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        if(studentRes==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentRes);
    }

    //    3. get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {
        List<CreateStudentResponseDto> studentlist = studentService.getAllStudents();
        if(studentlist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentlist);

    }

    //    4. update student
    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto studentReq) {
        UpdateStudentResponseDto studentRes = studentService.updateStudent(id, studentReq);
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