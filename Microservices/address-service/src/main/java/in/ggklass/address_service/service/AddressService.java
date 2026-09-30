package in.ggklass.address_service.service;

import in.ggklass.address_service.model.dto.AddressDto;
import in.ggklass.address_service.model.dto.AddressRequest;

import java.util.List;

public interface AddressService {

    List<AddressDto> saveAddress(AddressRequest addressRequest);

    List<AddressDto> updateAddress(AddressRequest addressRequest);

    AddressDto getSingleAddress(Long id);

    List<AddressDto> getAllAddress();

    void deleteAddress(Long id);

    List<AddressDto> getAddressByEmpId(Long empId);

}
