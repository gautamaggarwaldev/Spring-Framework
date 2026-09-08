package in.ggklass;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

    }
}
