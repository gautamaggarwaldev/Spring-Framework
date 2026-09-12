package in.ggklass.DtoExceptionHandlingDemo.service;

import in.ggklass.DtoExceptionHandlingDemo.dto.CreateStudentRequestDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.CreateStudentResponseDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.UpdateStudentRequestDto;
import in.ggklass.DtoExceptionHandlingDemo.dto.UpdateStudentResponseDto;
import in.ggklass.DtoExceptionHandlingDemo.entity.Student;
import in.ggklass.DtoExceptionHandlingDemo.exception.DuplicateResourceException;
import in.ggklass.DtoExceptionHandlingDemo.exception.ResourceNotFoundException;
import in.ggklass.DtoExceptionHandlingDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentRequestDto) {
        Student student = mapToEntity(studentRequestDto);
        if(emailExist(student)) {
            throw new DuplicateResourceException("Student with Email: "+ student.getEmail() + " is already exists");
        }
        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Student studentRes = studentRepository.findByIdAndDeletedIsFalse(id)
                            .orElseThrow(()->new ResourceNotFoundException("Student with id "+ id + " not found"));

        return mapToDto(studentRes);

    }

    public List<CreateStudentResponseDto> getAllStudents() {
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();
        return studentList.stream().map(this::mapToDto).toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()->
                                                            new ResourceNotFoundException("Student with id " + id + " not found."));
        existingStudent.setName(studentReq.getName());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(existingStudent);
        return mapToUpdateDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student with id " + id + " not found."));
        studentRepository.delete(student);
    }

    public void softDeleteStudent(Long id) {
        Student student = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()->new ResourceNotFoundException("Student with id " + id + " not found."));
        student.setDeleted(true);
        studentRepository.save(student);

    }

    private Student mapToEntity(CreateStudentRequestDto studentRequestDto) {
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setSubject(studentRequestDto.getSubject());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto studentResponseDto = new CreateStudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setMessage("Student saved successfully");
        studentResponseDto.setCreatedAt(student.getCreatedAt());
        studentResponseDto.setUpdatedAt(student.getUpdatedAt());

        return studentResponseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto studentResponseDto = new UpdateStudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setMessage("Student updated successfully");
        studentResponseDto.setUpdatedAt(student.getUpdatedAt());

        return studentResponseDto;
    }

    private boolean emailExist(Student student) {
       return studentRepository.existsByEmail(student.getEmail());
    }
}