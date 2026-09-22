package in.ggklass.SpringDataJPAdemo.service;

import in.ggklass.SpringDataJPAdemo.entity.Student;
import in.ggklass.SpringDataJPAdemo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()) {
            return student;
        }
        return Optional.empty();
    }

    public List<Student> getAllStudent(String name) {
//        Sort sort = Sort.by("age").descending();
//        Sort sort = Sort.by(Sort.Direction.ASC, "age");

        Sort sort = Sort.by("name").ascending()
                .and(
                        Sort.by("age").descending()
                );


        List<Student> students = studentRepository.findByName(name,sort);

        for(Student s : students) {
            System.out.println(s);
        }
        return students;
    }

    public void updateStudent(Student studentReq, Long id) {
        Optional<Student> studentRes = studentRepository.findById(id);
        Student student = studentRes.get();

        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());

    }

    public List<Student> findAll(String name) {
//        Sort sort = Sort.by("age").descending();
//        Sort sort = Sort.by(Sort.Direction.ASC, "age");

        Sort sort = Sort.by("name").ascending()
                .and(
                        Sort.by("age").descending()
                );

        Pageable pageable = PageRequest.of(0,3);

        Page<Student> studentPage = studentRepository.findAll(pageable);


        for(Student s : studentPage.getContent()) {
            System.out.println(s);
        }
        return studentPage.getContent();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
