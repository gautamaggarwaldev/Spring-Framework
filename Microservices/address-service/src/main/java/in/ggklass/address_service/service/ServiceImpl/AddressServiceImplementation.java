package in.ggklass.address_service.service.ServiceImpl;

import in.ggklass.address_service.exception.ResourceNotFoundException;
import in.ggklass.address_service.model.dto.AddressDto;
import in.ggklass.address_service.model.dto.AddressRequest;
import in.ggklass.address_service.model.dto.AddressRequestDto;
import in.ggklass.address_service.model.entity.Address;
import in.ggklass.address_service.repository.AddressRepository;
import in.ggklass.address_service.service.AddressService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class AddressServiceImplementation implements AddressService {

    private AddressRepository addressRepository;
    private ModelMapper modelMapper;

    public AddressServiceImplementation(AddressRepository addressRepository
            , ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressDto> saveAddress(AddressRequest addressRequest) {
        List<Address> listToSave = saveOrUpdateAddressRequest(addressRequest);
        List<Address> savedAddress = addressRepository.saveAll(listToSave);
        return savedAddress.stream().map(address->modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public List<AddressDto> updateAddress(AddressRequest addressRequest) {
        List<Address> addressByEmpId = addressRepository.findAllByEmpId(addressRequest.getEmpId());
        if(addressByEmpId.isEmpty()){
            log.info("No address found for employee id {}", addressRequest.getEmpId());
            log.info("Creating new address for employee id {}", addressRequest.getEmpId());
        }

        List<Address> listToUpdate = saveOrUpdateAddressRequest(addressRequest);

        List<Long> upcomingNonNullIds = listToUpdate.stream().map(Address::getId).filter(Objects::nonNull).toList();
        List<Long> existingIds = addressByEmpId.stream().map(Address::getId).toList();

        List<Long> idsToDelete = existingIds.stream().filter(id -> !upcomingNonNullIds.contains(id)).toList();
        if(!idsToDelete.isEmpty()){
            addressRepository.deleteAllById(idsToDelete);
        }

        List<Address> updatedAddress = addressRepository.saveAll(listToUpdate);
        return updatedAddress.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public AddressDto getSingleAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Address not found with this id: " + id
        ));
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        if(addressList.isEmpty()) {
            throw new ResourceNotFoundException("Not addresses are found");
        }
        return addressList.stream().map(address->modelMapper.map(address, AddressDto.class)).toList();
    }

    @Override
    public void deleteAddress(Long id) {

        Address address = addressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "Address with this id: " + id + " is not found"
        ));

        addressRepository.delete(address);
    }

    @Override
    public List<AddressDto> getAddressByEmpId(Long empId) {
        List<Address> addressByEmpId = addressRepository.findAllByEmpId(empId);
        if(addressByEmpId.isEmpty()){
            throw new ResourceNotFoundException("No address found for employee id: " + empId);
        }
        return addressByEmpId.stream().map(address -> modelMapper.map(address, AddressDto.class)).toList();
    }


    private List<Address> saveOrUpdateAddressRequest(AddressRequest addressRequest) {

        List<Address> listToSave = new ArrayList<>();
        for(AddressRequestDto addressRequestDto : addressRequest.getAddressRequestDtoList()) {
            Address address = new Address();

            address.setId(addressRequestDto.getId() != null ? addressRequestDto.getId() : null);
            address.setStreet(addressRequestDto.getStreet());
            address.setCity(addressRequestDto.getCity());
            address.setCountry(addressRequestDto.getCountry());
            address.setPinCode(addressRequestDto.getPinCode());
            address.setAddressType(addressRequestDto.getAddressType());
            address.setEmpId(addressRequest.getEmpId());

            listToSave.add(address);
        }
        return listToSave;
    }
}
