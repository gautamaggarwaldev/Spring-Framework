package in.ggklass.CRUDSpringBootDemo.repository;

import in.ggklass.CRUDSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRespository {
    public Student saveStudent(Student student) {
        System.out.println("Inside student repository");
        System.out.println("Exiting student repository");
        Student s1 = new Student();

        s1.setName("Garima");
        s1.setEmail("Garima123@gmail.com");
        s1.setAge(27);
        s1.setRollNo(15);
        s1.setSubject("Spring-Framework");

        return s1;
    }
}
