package in.ggklass.SpringTestingDemo.repository;

import in.ggklass.SpringTestingDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByName(String name);
}
