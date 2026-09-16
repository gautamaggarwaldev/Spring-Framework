package in.ggklass.AOPDemoTwo.aspect;

import in.ggklass.AOPDemoTwo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Component
@Aspect
public class LoggingAspect {
    private final ResourceUrlProvider resourceUrlProvider;

    public LoggingAspect(ResourceUrlProvider resourceUrlProvider) {
        this.resourceUrlProvider = resourceUrlProvider;
    }

//    @Before("execution(String in.ggklass.AOPDemoTwo.service.StudentService.createStudent())")
//    public void logBefore(JoinPoint jp) {
//        System.out.println("Student going to be saved.");
//        Object[] arr = jp.getArgs();
//        System.out.println(arr);
//        boolean flag = false;
//        if(!flag) {
//            throw new RuntimeException("Execution of method is not allowed");
//        }
//    }


//    @AfterReturning(value = "execution(* in.ggklass.AOPDemoTwo.service.StudentService.createStudent(..))",
//            returning = "result")
//    public void logAfterReturning(Student result) {
////        System.out.println("logAfterReturning called.");
//        result.setName("Gautam");
//        result.setAge(25);
//        System.out.println("Intercepted createStudent()");
//    }

//    @AfterThrowing(value = "execution(* in.ggklass.AOPDemoTwo.service.StudentService.createStudent(..))", throwing = "exception")
//    public void logAfterThrowing(Throwable exception) {
//
//        System.out.println("Exception type: " + exception.getClass().getName());
//        System.out.println("Exception message: " + exception.getMessage());
//        System.out.println("An exception occurred.");
//    }

//    @After(value = "execution(* in.ggklass.AOPDemoTwo.service.StudentService.createStudent(..))")
//    public void logAfter() {
//
//        System.out.println("logAfter method executed.");
//    }



//    @Around(value = "execution(* in.ggklass.AOPDemoTwo.service.StudentService.createStudent(..))")
//    public Object logAround(ProceedingJoinPoint jp) throws Throwable {
//
//        System.out.println("Starting execution: " + jp.getSignature().getName());
//
//        try {
//            Object result = jp.proceed();
//            System.out.println("Execution successful.");
//            return result;
//        }
//        catch (Exception e) {
//            System.out.println("Execution failed: " + e.getMessage());
//            throw e;
//        }
//        finally {
//            System.out.println("Execution completed.");
//        }
//    }

    @Around(value = "execution(* in.ggklass.AOPDemoTwo.service.StudentService.dummyMethod(..))")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable {

//        Object[] arr =  jp.getArgs();
//
//       String originalString = (String) arr[0];
//
//       String modifiedString = originalString.toUpperCase();
//
//       Object[] modifiedArr = {
//               modifiedString
//       };
//
//       String returnType = (String) jp.proceed(modifiedArr);
//
//       returnType = returnType + " : String Intercepted";
//
//       return returnType;

        Object return1 = jp.proceed();

        System.out.println("Intercepted request calliong again");

        Object return2 = jp.proceed();

        return return2;
    }


}
