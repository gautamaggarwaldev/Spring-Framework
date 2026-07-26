package in.ggklass;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Lazy
// @Scope("prototype")
public class OrderService {

    private PaymentService payment;

    public OrderService(@Lazy PaymentService payment) {
        this.payment = payment;
    }

    public void placeOrder() {
        payment.pay();

        System.out.println("Order Placed");
    }

    public void getOrderDetails() {
        System.out.println("Order details...");
    }
}
