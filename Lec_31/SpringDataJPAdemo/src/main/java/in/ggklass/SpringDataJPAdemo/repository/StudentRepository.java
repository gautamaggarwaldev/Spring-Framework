package in.ggklass.SpringDataJPAdemo.repository;


import in.ggklass.SpringDataJPAdemo.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //...
    List<Student> findByName(String name, Sort sort);

    Optional<Student> findByEmailLike(String pattern);

    @Query(value="""
                    select * from student where email = :email
                """,
            nativeQuery = true)
    Optional<Student> findByEmail(@Param("email") String email);
}
