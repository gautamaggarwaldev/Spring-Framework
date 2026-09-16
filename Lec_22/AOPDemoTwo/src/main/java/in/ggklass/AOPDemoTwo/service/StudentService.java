package in.ggklass.AOPDemoTwo.service;

import in.ggklass.AOPDemoTwo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student) {
        System.out.println("Student saved.");
//        throw new RuntimeException("Runtime error happen");
        return student;
    }

    public String dummyMethod(String s) {
        System.out.println("dummy method called.");
        return s;
    }
}
