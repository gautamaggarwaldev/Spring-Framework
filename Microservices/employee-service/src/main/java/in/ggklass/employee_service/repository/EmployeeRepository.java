package in.ggklass.employee_service.repository;

import in.ggklass.employee_service.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByEmpEmail(String email);
}
