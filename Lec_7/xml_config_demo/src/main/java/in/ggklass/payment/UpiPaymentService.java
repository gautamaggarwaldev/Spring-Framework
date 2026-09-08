package in.ggklass.payment;

public class UpiPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Pay via Upi.");
    }
}
