package in.ggklass.TransactionDemo.repository;

import in.ggklass.TransactionDemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
