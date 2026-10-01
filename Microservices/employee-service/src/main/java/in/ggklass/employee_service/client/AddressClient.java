package in.ggklass.employee_service.client;

import in.ggklass.employee_service.model.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ADDRESS-SERVICE")
public interface AddressClient {

    @GetMapping("api/addresses/emp-id/{id}")
    List<AddressDto> getAddressByEmpId(@PathVariable Long id);
}
