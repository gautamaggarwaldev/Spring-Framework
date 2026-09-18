package in.ggklass.springJDBCdemo.repository;

import in.ggklass.springJDBCdemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class StudentRepository {

//    StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createStudent(Student student) {
        String sql =
                """
                    INSERT INTO students(name,email,age) VALUES (?,?,?)
                    """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge());

        if(rowAffected==1) {
            System.out.println("Student creation successful.");
        }
        else {
            System.out.println("Student deletion failed.");
        }
    }

    public void updateStudentById(Student student, Long id) {
        String sql = """
                        UPDATE students SET name=?, email=?, age=? WHERE id=?
                        """;
        int result = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge(), id);

        if(result==1) {
            System.out.println("Student updation successful.");
        }
        else {
            System.out.println("Student updation failed");
        }
    }

    public void deleteStudentById(Long id) {
        String sql = """
                      DELETE FROM students WHERE id=? 
                      """;

        int result = jdbcTemplate.update(sql, id);

        if(result==1) {
            System.out.println("Student deletion successful.");
        }
        else {
            System.out.println("Student deletion failed");
        }
    }

    public Student getStudentById(Long id) {
        String sql = """
                        SELECT id,name,email,age FROM students WHERE id=?
                        """;

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }


    public List<Student> getAllStudents() {
        String sql = """
                        SELECT id,name,email,age FROM students
                        """;

        List<Student> students = jdbcTemplate.query(sql, rowMapper);

        return students;
    }
}