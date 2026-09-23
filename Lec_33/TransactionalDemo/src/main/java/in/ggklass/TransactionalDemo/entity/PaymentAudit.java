package in.ggklass.TransactionalDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PaymentAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private BigDecimal amount;
    private Boolean paymentSuccess;

    public PaymentAudit(Long orderId, BigDecimal amount, Boolean paymentSuccess) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentSuccess = paymentSuccess;
    }
}
