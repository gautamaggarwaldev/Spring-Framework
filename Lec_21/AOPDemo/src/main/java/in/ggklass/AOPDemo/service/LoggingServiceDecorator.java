package in.ggklass.AOPDemo.service;

import in.ggklass.AOPDemo.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class LoggingServiceDecorator implements StudentService {

    private StudentServiceImpl studentServiceImpl;

    public LoggingServiceDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");

    }
}
