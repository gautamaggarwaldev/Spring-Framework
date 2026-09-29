package in.ggklass.employee_service.service.EmployeeServiceImpl;

import in.ggklass.employee_service.model.dto.EmployeeDto;
import in.ggklass.employee_service.model.entity.Employee;
import in.ggklass.employee_service.repository.EmployeeRepository;
import in.ggklass.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new RuntimeException("Employee already exists");
        }

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Employee with this id is not found"));

        modelMapper.map(employeeDto, employee);

        Employee updatedEmployee = employeeRepository.save(employee);

        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Employee with this id is not found"));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Employee with this id is not found"));

        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeRepository.findAll().stream().
                map(emp->modelMapper.map(emp,EmployeeDto.class)).toList();

        return employeeDtos;
    }
}
