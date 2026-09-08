package in.ggklass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // OrderService order = (OrderService) context.getBean("orderService");

        // OrderService order = context.getBean(OrderService.class);

//        OrderService order = context.getBean("orderService", OrderService.class);
////        PaymentService payment = context.getBean(PaymentService.class);
////        payment.pay();
//        order.placeOrder();

        UserService user = context.getBean(UserService.class);
//        System.out.println(user.getUsernames());

        context.close();
    }
}