package in.ggklass.AOPDemo.repository;

import in.ggklass.AOPDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved.");
    }

}