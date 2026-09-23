package in.ggklass.TransactionalDemo.service;

import in.ggklass.TransactionalDemo.entity.Order;
import in.ggklass.TransactionalDemo.entity.PaymentAudit;
import in.ggklass.TransactionalDemo.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED,
                    isolation = Isolation.REPEATABLE_READ)
    public void audit(Order order) {
        PaymentAudit paymentAudit = new
                PaymentAudit(order.getId(), order.getAmount(), true);

        paymentAuditRepository.save(paymentAudit);

    }
}
