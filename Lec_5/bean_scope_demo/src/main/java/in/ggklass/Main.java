package in.ggklass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main 
{
    public static void main(String[] args) 
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        OrderService order2 = context.getBean(OrderService.class);

        //true ---> in case of singleton and false in case of prototype
        System.out.println(order == order2); 
    }
}