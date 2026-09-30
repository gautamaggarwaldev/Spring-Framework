package in.ggklass.address_service.controller;

import in.ggklass.address_service.model.dto.AddressDto;
import in.ggklass.address_service.model.dto.AddressRequest;
import in.ggklass.address_service.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<List<AddressDto>> createAddress(@RequestBody AddressRequest addressRequest) {
        List<AddressDto> addressDtoList = addressService.saveAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Long id) {
        AddressDto addressDto = addressService.getSingleAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressDto);
    }

    @GetMapping("/emp-id/{id}")
    public ResponseEntity<List<AddressDto>> getAddressByEmpId(@PathVariable Long id) {
        List<AddressDto> response = addressService.getAddressByEmpId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressDtoList = addressService.getAllAddress();
        return ResponseEntity.status(HttpStatus.OK).body(addressDtoList);

    }

    @PutMapping
    public ResponseEntity<List<AddressDto>> updateAddress(@RequestBody AddressRequest addressRequest) {
        List<AddressDto> addressDtoList = addressService.updateAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.OK).body(addressDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }
}
