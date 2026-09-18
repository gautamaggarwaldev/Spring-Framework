package in.ggklass;

import in.ggklass.model.Student;
import in.ggklass.repository.StudentReposiotry;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        System.out.println("Hello World");
        StudentReposiotry studentReposiotry = new StudentReposiotry();

        studentReposiotry.createStudent(new Student("jhon", "jhon@gmail.com", 27));

        studentReposiotry.updateStudentById(new Student("Aggarwal", "gautam123@gmail.com", 28), 3L);

        studentReposiotry.deleteStudentById(3L);

        studentReposiotry.getStudentById(2L);

        studentReposiotry.getAllStudents();

    }

}
