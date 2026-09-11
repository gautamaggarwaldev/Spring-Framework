package in.ggklass.repository;

import in.ggklass.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private Map<Long, Student> studentdb;

    public StudentRepository() {
        studentdb = new HashMap<>();
    }

    public Student save(Student student) {
        studentdb.put(student.getId(), student);
        return student;
    }

    public Student findById(Long id) {
        return studentdb.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentdb.values());
    }
}
