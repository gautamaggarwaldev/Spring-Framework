package in.ggklass.JPARelationships.service;

import in.ggklass.JPARelationships.model.Department;
import in.ggklass.JPARelationships.model.Student;
import in.ggklass.JPARelationships.repository.DepartmentRepository;
import in.ggklass.JPARelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId) {
        Department department = departmentRepository.getDepartmentById(deptId);

        department.getStudents().add(student);
        student.setDepartment(department);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName) {
        Department department = new Department();
        department.setName(deptName);

        department.getStudents().add(student);
        student.setDepartment(department);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
