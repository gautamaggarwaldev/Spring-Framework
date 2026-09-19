package in.ggklass.HibernateDemo.service;

import in.ggklass.HibernateDemo.model.Student;
import in.ggklass.HibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq, Long id) {
        Student student = studentRepository.getById(id);

        if(student==null) {
            throw new RuntimeException("Student with this id is not found");
        }

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        if(student==null) {
            throw new RuntimeException("Student with this id is not found");
        }
        studentRepository.remove(student);
    }
}
