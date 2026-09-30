package in.ggklass.address_service.model.entity;

import in.ggklass.address_service.model.enums.AddressType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empId;
    private String street;
    private Long pinCode;
    private String city;
    private String country;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address(Long empId, String street, Long pinCode, String city,
                   String country, AddressType addressType) {
        this.empId = empId;
        this.street = street;
        this.pinCode = pinCode;
        this.city = city;
        this.country = country;
        this.addressType = addressType;
    }
}
