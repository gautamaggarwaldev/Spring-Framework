package in.ggklass.AOPDemoThree.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Pointcut("within(in.ggklass.AOPDemoThree.service..*) && execution(public * * (..))" )
//    public void logPublicServiceMethod() {
//            //.....
//    }

//    @Before("execution(* in.ggklass.AOPDemoThree.service.StudentService.*(..))") ---> method level
//    @Before("within(in.ggklass.AOPDemoThree.service.StudentService)")
//    @Before("@annotation(jdk.jfr.Timestamp)")
//    @Before("bean(studentService) || bean(studentController)")
//    @Before("bean(studentService) && execution(public * * (..))")

//   @Before("@within(org.springframework.stereotype.Service)")  ---> class level
//    @Before("@target(org.springframework.stereotype.Service)")  // ---> class level
//    public void logBefore() {
//        System.out.println("Method Intercepted.");
//    }

//    @Before("args(in.ggklass.AOPDemoThree.dto.Student)" +
//            " && within(in.ggklass.AOPDemoThree.service..*)")  // ---> method level
//    public void logBefore2() {
//        System.out.println("Method Intercepted.");
//    }

//    @Before("@args(jdk.jfr.Timestamp) && within(in.ggklass.AOPDemoThree.service..*)")  // --->
//    public void logBefore3() {
//        System.out.println("Method Intercepted.");
//    }

//    @Before("this(in.ggklass.AOPDemoThree.service.StudentService)")
    @Before("target(in.ggklass.AOPDemoThree.service.StudentService)")
    public void logBefore4() {
        System.out.println("Method Intercepted");
    }

//    @Before("execution(public in.ggklass.AOPDemoThree.dto.Student" +
//            " in.ggklass.AOPDemoThree.service.StudentService.createStudent" +
//            "(in.ggklass.AOPDemoThree.dto.Student))")
//    public void logBefore2() {
//        System.out.println("Method Intercepted: 2");
//    }
}
