package in.ggklass.employee_service.controller;

import in.ggklass.employee_service.exception.MissingParameterException;
import in.ggklass.employee_service.model.dto.EmployeeDto;
import in.ggklass.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeRes = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                                      @PathVariable Long id) {
        EmployeeDto employeeRes = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.status(HttpStatus.OK).body(employeeRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        EmployeeDto employeeRes = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeRes);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtos);
    }

    @GetMapping("/empCodeCompany")
    public ResponseEntity<EmployeeDto> getEmployeeByEmpCodeAndEmpCompany(@RequestParam(required = false) String empCode,
                                                                         @RequestParam(required = false) String empCompany) {
        List<String> missingParams = new ArrayList<>();
        if(empCode==null || empCode.trim().isEmpty()) {
            missingParams.add("empCode");
        }
        if(empCompany==null || empCompany.trim().isEmpty()) {
            missingParams.add("empCompany");
        }
        if(!missingParams.isEmpty()) {
            String finalMessage = missingParams.stream().collect(Collectors.joining(","));
            throw new MissingParameterException("Please provide: " + finalMessage);
        }
        EmployeeDto employeeRes = employeeService.getEmployeeByEmpCodeAndEmpCompany(empCode, empCompany);

        return ResponseEntity.status(HttpStatus.OK).body(employeeRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
}
