package in.ggklass.service;

import in.ggklass.entity.Student;
import in.ggklass.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
