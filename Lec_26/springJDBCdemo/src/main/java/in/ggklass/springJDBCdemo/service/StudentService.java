package in.ggklass.springJDBCdemo.service;


import in.ggklass.springJDBCdemo.model.Student;
import in.ggklass.springJDBCdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudentById(student, student.getId());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudentById(id);
    }
}
