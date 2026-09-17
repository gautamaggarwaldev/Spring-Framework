package in.ggklass.AOPDemoFour.aspect;

import in.ggklass.AOPDemoFour.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Around("@annotation(in.ggklass.AOPDemoFour.annotation.TrackExecutionTime)")


    @Around("@annotation(trackExecutionTime)")
    public Object trackExecutionTime(ProceedingJoinPoint jp, TrackExecutionTime trackExecutionTime)
            throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return jp.proceed();
        }
        finally {
            long end = System.currentTimeMillis();
            long duration = end-start;

            String operation = trackExecutionTime.operation();

            if(operation.isBlank()) {
                operation = jp.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT!!! " + "Time taken by " + operation + " : " + duration);
            }
            else System.out.println("Time taken by " + operation + " : " + duration);
        }
    }
}
