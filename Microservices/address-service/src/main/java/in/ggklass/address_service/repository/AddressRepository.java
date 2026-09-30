package in.ggklass.address_service.repository;

import in.ggklass.address_service.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByEmpId(Long empId);

}
