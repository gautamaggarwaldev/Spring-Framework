package in.ggklass.AOPDemo.service;

import in.ggklass.AOPDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService {

    private LoggingServiceDecorator loggingServiceDecorator;

    public ExecutionTimeService(LoggingServiceDecorator loggingServiceDecorator) {
        this.loggingServiceDecorator = loggingServiceDecorator;
    }

    public void createStudent(Student student) {
        long start = System.currentTimeMillis();
        loggingServiceDecorator.createStudent(student);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
