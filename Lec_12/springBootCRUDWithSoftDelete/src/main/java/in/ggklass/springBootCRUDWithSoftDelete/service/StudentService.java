package in.ggklass.springBootCRUDWithSoftDelete.service;

import in.ggklass.springBootCRUDWithSoftDelete.entity.Student;
import in.ggklass.springBootCRUDWithSoftDelete.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        studentReq.setDeleted(false);
        Student studentRes = studentRepository.save(studentReq);
        return studentRes;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentRes = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentRes.isPresent()) {
            return studentRes.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean softDeleteStudent(Long id) {
        Optional<Student> student = studentRepository.findByIdAndDeletedIsFalse(id);
        if(student.isEmpty()) {
            return false;
        }
        Student studentToSave = student.get();

        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true;
    }
}