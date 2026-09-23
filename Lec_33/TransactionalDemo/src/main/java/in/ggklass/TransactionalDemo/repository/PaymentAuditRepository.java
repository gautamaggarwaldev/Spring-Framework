package in.ggklass.TransactionalDemo.repository;

import in.ggklass.TransactionalDemo.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit, Long> {

}
