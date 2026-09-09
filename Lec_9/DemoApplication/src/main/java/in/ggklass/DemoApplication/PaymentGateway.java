package in.ggklass.DemoApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    @Value("${paymentGateway.retry-count}")
//    private int retryCount;
//
//    @Value("${paymentGateway.type:razorpay}")
//    private String type;

//    public PaymentGateway(@Value("${paymentGateway.retry-count}") int retryCount,
//                          @Value("${paymentGateway.type}")String type)
//    {
//        this.retryCount = retryCount;
//        this.type = type;
//    }

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }
    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }
    public boolean getIsEnabled() {
        return paymentProperties.isEnabled();
    }
    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public void print() {
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getIsEnabled());
        System.out.println(getTimeout());
    }
}
