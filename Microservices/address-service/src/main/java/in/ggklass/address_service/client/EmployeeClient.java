package in.ggklass.address_service.client;

import in.ggklass.address_service.model.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employeeClient", url = "${employee.service.url}")
public interface EmployeeClient {

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id);
}
