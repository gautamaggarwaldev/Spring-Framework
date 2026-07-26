package in.ggklass;

import org.springframework.stereotype.Component;

@Component
public class B {
    
    private OrderService order;

    public B(OrderService order) {
        this.order = order;
    }
}
