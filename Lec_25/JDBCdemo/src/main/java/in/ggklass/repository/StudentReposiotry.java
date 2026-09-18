package in.ggklass.repository;


import in.ggklass.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentReposiotry {

    String url = "jdbc:mysql://localhost:3306/student_crud";
    String username = "root";
    String password = "gautam2004";


    public void createStudent(Student student) {
        String sql = """
                        INSERT INTO students(name,email,age) VALUES (?,?,?)
                        """;
        try (
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected==1) {
                System.out.println("Student creation successful.");
            }
            else {
                System.out.println("Student deletion failed.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection ERROR::: " + e);
        }
    }

    public void updateStudentById(Student student, Long id) {

        String sql = """
                        UPDATE students SET name=?, email=?, age=? WHERE id=?
                        """;

        try (
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,id);

            int result = preparedStatement.executeUpdate();

            if(result==1) {
                System.out.println("Student updation successful.");
            }
            else {
                System.out.println("Student updation failed");
            }
        } catch (SQLException e) {
            System.out.println("Database connection ERROR::: " + e);
        }
    }

    public void deleteStudentById(Long id) {

        String sql = """
                      DELETE FROM students WHERE id=? 
                      """;

        try (
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setLong(1,id);

            int result = preparedStatement.executeUpdate();

            if(result==1) {
                System.out.println("Student deletion successful.");
            }
            else {
                System.out.println("Student deletion failed");
            }

        } catch (SQLException e) {
            System.out.println("Database connection ERROR::: " + e);
        }
    }

    public void getStudentById(Long id) {

        String sql = """
                        SELECT id,name,email,age FROM students WHERE id=?
                        """;

        try (
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setLong(1,id);

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
                    ) {
               if(resultSet.next()) {
                   Student student = mapToRow(resultSet);
                   System.out.println(student);
               }
            }
        } catch (SQLException e) {
            System.out.println("Database connection ERROR::: " + e);
        }
    }


    public void getAllStudents() {

        String sql = """
                        SELECT id,name,email,age FROM students
                        """;

        try (
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            try(
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                List<Student> students = new ArrayList<>();
                while(resultSet.next()) {
                    Student student = mapToRow(resultSet);
                    students.add(student);
                    System.out.println(student);
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection ERROR::: " + e);
        }
    }

    private Student mapToRow(ResultSet rs) throws SQLException {
        Student student = new Student();

        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));

        return student;
    }





//    public void completeCRUD() {
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            Statement statement = connection.createStatement();
//
//            String sql = "SELECT id,name,email,age FROM students WHERE id=2";
//
//            boolean result = statement.execute(sql);
//
//            if(result==true) {
//                ResultSet resultSet = statement.getResultSet();
//            }
//            else {
//                int rowAffected = statement.getUpdateCount();
//            }
//            connection.close();
//
//        } catch (SQLException e) {
//            System.out.println("Database connection ERROR::: " + e);
//        }
//    }




}
