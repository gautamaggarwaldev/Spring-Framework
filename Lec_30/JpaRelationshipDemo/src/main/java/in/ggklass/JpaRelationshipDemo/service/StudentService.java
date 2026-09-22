package in.ggklass.JpaRelationshipDemo.service;

import in.ggklass.JpaRelationshipDemo.model.Department;
import in.ggklass.JpaRelationshipDemo.model.Profile;
import in.ggklass.JpaRelationshipDemo.model.Student;
import in.ggklass.JpaRelationshipDemo.repository.DepartmentRepository;
import in.ggklass.JpaRelationshipDemo.repository.ProfileReposiotry;
import in.ggklass.JpaRelationshipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    private ProfileReposiotry profileReposiotry;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository, ProfileReposiotry profileReposiotry) {

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileReposiotry = profileReposiotry;
    }

    @Transactional
    public void createStudent(Student student) {
        Department department = new Department();
        department.setName("CSE");

        Profile profile = new Profile();
        profile.setBio("Sample bio");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileReposiotry.save(profile);
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        Student s1 = studentRepository.findById(id);
        System.out.println("Lazily fetched Student");

        Department d1 = s1.getDepartment();

        System.out.println("Lazily fetched Department");

        Profile p1 = s1.getProfile();

        System.out.println("Lazily fetched Profile");

        return s1;
    }
}
