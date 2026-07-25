package in.ggklass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import in.ggklass.payment.PaymentService;

// @Component
public class OrderService {

    // @Autowired ---> field injection (not recommended)
    private final PaymentService paymentService;
    
    //@Autowired //in contructor injection if there is a one constructor then autowired is optional
    public OrderService(@Qualifier("upi") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // @Autowired
    // public void setPaymentService(PaymentService paymentService) {
    //     this.paymentService = paymentService;
    // }
    
    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
