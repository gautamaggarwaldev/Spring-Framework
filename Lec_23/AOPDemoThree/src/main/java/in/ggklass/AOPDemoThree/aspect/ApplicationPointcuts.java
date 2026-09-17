package in.ggklass.AOPDemoThree.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {
    @Pointcut("within(in.ggklass.AOPDemoThree.controller..*)")
    public void controllerLayer() {
        // emoty body
    }

    @Pointcut("within(in.ggklass.AOPDemoThree.service..*)")
    public void serviceLayer() {
        // empty body
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod() {
        // empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod() {
        // empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod() {
        // empty body
    }
}
