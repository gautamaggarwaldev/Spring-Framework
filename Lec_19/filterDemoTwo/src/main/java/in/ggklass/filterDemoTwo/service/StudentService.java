package in.ggklass.filterDemoTwo.service;

import in.ggklass.filterDemoTwo.dto.Student;
import in.ggklass.filterDemoTwo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto createStudent(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");
        return studentResponseDto;
    }
}
