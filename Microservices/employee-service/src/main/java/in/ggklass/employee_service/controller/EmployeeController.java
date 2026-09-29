package in.ggklass.employee_service.controller;

import in.ggklass.employee_service.model.dto.EmployeeDto;
import in.ggklass.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
}
