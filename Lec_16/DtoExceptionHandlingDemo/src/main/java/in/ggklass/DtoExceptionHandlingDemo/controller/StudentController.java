package in.ggklass.DtoExceptionHandlingDemo.controller;


import in.ggklass.DtoExceptionHandlingDemo.dto.CreateStudentRequestDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.CreateStudentResponseDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.UpdateStudentRequestDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.UpdateStudentResponseDto;
import in.ggklass.DtoExceptionHandlingDemo.entity.Student;
import in.ggklass.DtoExceptionHandlingDemo.service.StudentService;
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
    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto studentRequestDto) {
        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //    2. read one student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id) {
        CreateStudentResponseDto studentRes = studentService.getStudent(id);
        return ResponseEntity.ok(studentRes);
    }

    //    3. get all students
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {
        List<CreateStudentResponseDto> studentlist = studentService.getAllStudents();
        return ResponseEntity.ok(studentlist);

    }

    //    4. update student
    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto studentReq) {
        UpdateStudentResponseDto studentRes = studentService.updateStudent(id, studentReq);
        return ResponseEntity.ok(studentRes);
    }

    //    5. delete a student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //    6. soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id) {
        studentService.softDeleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}