package in.ggklass;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import in.gg.CartService;
import in.ggklass.payment.CardPayment;
import in.ggklass.payment.PaymentService;
import in.ggklass.payment.UpiPayment;

@Configuration
@ComponentScan("in.ggklass")
public class AppConfig {
    // ....
    @Bean
    public User createUser() {
        return new User("Garima", 27);
    }

    @Bean
    public CartService createCartService() {
        return  new CartService();
    }

    @Bean
    @Qualifier
    public PaymentService createCardPayment() {
        return new CardPayment();
    }
    @Bean
    // @Primary
    @Qualifier
    public PaymentService createUpiPayment() {
        return new UpiPayment();
    }

    @Bean
    public OrderService createOrderService(@Qualifier("createCardPayment")PaymentService payment) {
        return new OrderService(payment);
    }
}
