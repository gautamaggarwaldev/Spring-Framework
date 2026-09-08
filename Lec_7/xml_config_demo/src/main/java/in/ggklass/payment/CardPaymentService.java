package in.ggklass.payment;

public class CardPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Pay via Card.");
    }
}
