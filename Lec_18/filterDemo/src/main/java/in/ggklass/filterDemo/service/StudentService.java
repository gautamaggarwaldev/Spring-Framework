package in.ggklass.filterDemo.service;

import in.ggklass.filterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student) {
        System.out.println("Student created.");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
        return;
    }
}
