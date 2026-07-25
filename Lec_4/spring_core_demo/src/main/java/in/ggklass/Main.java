package in.ggklass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.gg.CartService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

        // CartService cs = context.getBean(CartService.class); //from in.gg:demo_project jar file
        // cs.AddToCart();


        // User user = context.getBean(User.class);
        // System.out.println(user.getName());

        // PaymentService payment = context.getBean(PaymentService.class);
        // payment.pay();
    }
}