package in.ggklass;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class A {
    B b;
    public A(B b) {
        this.b = b;
    }

    @PostConstruct
    public void setB() {
        b.setA(this);
    }
}
