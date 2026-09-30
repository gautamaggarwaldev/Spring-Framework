package in.ggklass.employee_service.service.EmployeeServiceImpl;

import in.ggklass.employee_service.exception.BadRequestException;
import in.ggklass.employee_service.exception.ResourceNotFoundException;
import in.ggklass.employee_service.model.dto.EmployeeDto;
import in.ggklass.employee_service.model.entity.Employee;
import in.ggklass.employee_service.repository.EmployeeRepository;
import in.ggklass.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository,
                                         ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
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

        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeRepository.findAll().stream().
                map(emp->modelMapper.map(emp,EmployeeDto.class)).toList();

        if(employeeDtos.isEmpty()) {
            throw new ResourceNotFoundException("No employee is present");
        }

        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployeeByEmpCodeAndEmpCompany(String empCode, String empCompany) {
        Employee employee = employeeRepository.findEmployeeByEmpCodeAndEmpCompany(empCode, empCompany).orElseThrow(()->
                new ResourceNotFoundException("Employee not found with code and company " + empCode + " " + empCompany));

        return modelMapper.map(employee, EmployeeDto.class);
    }
}
