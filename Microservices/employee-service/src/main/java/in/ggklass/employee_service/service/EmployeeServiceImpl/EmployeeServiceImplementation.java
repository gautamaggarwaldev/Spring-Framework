package in.ggklass.employee_service.service.EmployeeServiceImpl;

import in.ggklass.employee_service.client.AddressClient;
import in.ggklass.employee_service.exception.BadRequestException;
import in.ggklass.employee_service.exception.ResourceNotFoundException;
import in.ggklass.employee_service.model.dto.AddressDto;
import in.ggklass.employee_service.model.dto.EmployeeDto;
import in.ggklass.employee_service.model.entity.Employee;
import in.ggklass.employee_service.repository.EmployeeRepository;
import in.ggklass.employee_service.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private AddressClient addressClient;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository,
                                         ModelMapper modelMapper, AddressClient addressClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        if(employeeRepository.existsByEmpEmail(employeeDto.getEmpEmail())) {
            throw new BadRequestException("Employee with this email: " +
                    employeeDto.getEmpEmail() + " is already exists");
        }

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee with this id : " + id + " is not found"));

        modelMapper.map(employeeDto, employee);

        Employee updatedEmployee = employeeRepository.save(employee);

        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee with this id : " + id + " is not found"));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee with this id : " + id + " is not found"));

        List<AddressDto> addresses = new ArrayList<>();
        EmployeeDto employeeDto =  modelMapper.map(employee, EmployeeDto.class);

        try {
            addresses = addressClient.getAddressByEmpId(id);
            employeeDto.setAddressDto(addresses);
        } catch (Exception e) {
            log.error("No addresses found for employee id: " + id);
        }
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeRepository.findAll().stream().
                map(emp->modelMapper.map(emp,EmployeeDto.class)).toList();

        if(employeeDtos.isEmpty()) {
            throw new ResourceNotFoundException("No employee is present");
        }

        List<EmployeeDto> response = new ArrayList<>();

        for(EmployeeDto employee : employeeDtos) {
            List<AddressDto> addresses = new ArrayList<>();

            try {
                addresses = addressClient.getAddressByEmpId(employee.getId());
                employee.setAddressDto(addresses);
            } catch (Exception e) {
                log.error("No addresses found for employee id: " + employee.getId());
            }
            response.add(employee);
        }
        return response;
    }

    @Override
    public EmployeeDto getEmployeeByEmpCodeAndEmpCompany(String empCode, String empCompany) {
        Employee employee = employeeRepository.findEmployeeByEmpCodeAndEmpCompany(empCode, empCompany).orElseThrow(()->
                new ResourceNotFoundException("Employee not found with code and company " + empCode + " " + empCompany));

        return modelMapper.map(employee, EmployeeDto.class);
    }
}
