package in.ggklass.CrudDTODemo.service;

import in.ggklass.CrudDTODemo.dto.CreateStudentRequestDto;
import in.ggklass.CrudDTODemo.dto.CreateStudentResponseDto;
import in.ggklass.CrudDTODemo.dto.UpdateStudentRequestDto;
import in.ggklass.CrudDTODemo.dto.UpdateStudentResponseDto;
import in.ggklass.CrudDTODemo.entity.Student;
import in.ggklass.CrudDTODemo.repository.StudentRepository;
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
        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Optional<Student> studentRes = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentRes.isPresent()) {
            return mapToDto(studentRes.get());
        }
        return null;
    }

    public List<CreateStudentResponseDto> getAllStudents() {
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();

        return studentList.stream().map(this::mapToDto).toList();
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapToUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean softDeleteStudent(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isEmpty()) {
            return false;
        }
        Student studentToSave = student.get();

        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true;
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
}