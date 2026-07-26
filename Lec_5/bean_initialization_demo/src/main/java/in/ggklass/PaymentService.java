package in.ggklass;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
// @Scope("prototype")
public class PaymentService {

    private OrderService order;
    
    public PaymentService(OrderService order) {
        this.order = order;
    }

    public void pay() {
        System.out.println("Payment done");

        order.getOrderDetails();
    }
}
