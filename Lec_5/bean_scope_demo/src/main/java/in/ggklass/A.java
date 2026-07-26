package in.ggklass;

import org.springframework.stereotype.Component;

@Component
public class A {
    
    private OrderService order;

    public A(OrderService order) {
        this.order = order;
    }
}
