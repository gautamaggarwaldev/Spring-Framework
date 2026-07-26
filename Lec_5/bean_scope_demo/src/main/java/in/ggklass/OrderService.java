package in.ggklass;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
@Scope("singleton")
public class OrderService {

    public OrderService() {
        System.out.println("OrderService created");
    }
    
    public void orderPlaced() {
        System.out.println("Order Placed");
    }
}
