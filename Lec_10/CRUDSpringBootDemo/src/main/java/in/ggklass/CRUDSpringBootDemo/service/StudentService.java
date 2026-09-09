package in.ggklass.CRUDSpringBootDemo.service;

import in.ggklass.CRUDSpringBootDemo.entity.Student;
import in.ggklass.CRUDSpringBootDemo.repository.StudentRespository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("Inside student service");
        Student studentRes = studentRespository.saveStudent(studentReq);
        System.out.println("Exiting student service");
        return studentRes;
    }
}
