package in.ggklass.address_service.model.dto;

import in.ggklass.address_service.model.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {

    private Long id;
    private String street;
    private Long pinCode;
    private String city;
    private String country;
    private AddressType addressType;
}
