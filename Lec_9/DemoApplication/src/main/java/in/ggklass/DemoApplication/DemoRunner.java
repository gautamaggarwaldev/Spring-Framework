package in.ggklass.DemoApplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner {
    private PaymentGateway gateway;

    public DemoRunner(PaymentGateway gateway) {
        this.gateway = gateway;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        gateway.print();
    }
}
