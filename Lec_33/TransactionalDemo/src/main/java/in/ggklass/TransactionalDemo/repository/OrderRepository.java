package in.ggklass.TransactionalDemo.repository;

import in.ggklass.TransactionalDemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
