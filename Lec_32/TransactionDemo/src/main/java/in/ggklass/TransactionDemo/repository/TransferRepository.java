package in.ggklass.TransactionDemo.repository;

import in.ggklass.TransactionDemo.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord, Long> {
}
