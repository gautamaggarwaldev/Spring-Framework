package in.ggklass.AOPDemoFour.service;

import in.ggklass.AOPDemoFour.annotation.TrackExecutionTime;
import in.ggklass.AOPDemoFour.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(warnAfter = 1000, operation = "Creating new student")
    public Student createStudent(Student student) {
        System.out.println("Student saved.");
        return student;
    }

    @TrackExecutionTime(warnAfter = 1500, operation = "All student data")
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}
        System.out.println(s);
        return s;
    }
}
