package in.ggklass.employee_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    private String empCode;
    private String empEmail;
    private double empSalary;
    private String empCompany;

    public Employee(String empCompany, double empSalary, String empEmail, String empCode, String empName) {
        this.empCompany = empCompany;
        this.empSalary = empSalary;
        this.empEmail = empEmail;
        this.empCode = empCode;
        this.empName = empName;
    }
}
