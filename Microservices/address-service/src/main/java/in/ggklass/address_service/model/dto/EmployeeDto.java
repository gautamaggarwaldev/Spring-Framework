package in.ggklass.address_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empName;
    private String empCode;
    private String empEmail;
    private double empSalary;
    private String empCompany;
}
