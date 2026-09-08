package in.ggklass;

import in.ggklass.payment.PaymentService;

public class OrderService {

    private PaymentService paymentService;


    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("Order Service is Created.");
    }

//    public void setPaymentServiceBean(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed.");
    }
}
