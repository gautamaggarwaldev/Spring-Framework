package in.ggklass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderService {

    @Autowired
    private PaymentService payment;

    // public OrderService(PaymentService payment) {
    //     this.payment = payment;
    // }


    public void placeOrder() {
        System.out.println("Order Placed");
        payment.pay();
    }

    public void getOrderDetails() {
        System.out.println("Order Details...");
    }
}
