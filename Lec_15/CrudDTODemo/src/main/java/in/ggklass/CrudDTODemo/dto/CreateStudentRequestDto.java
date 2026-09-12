package in.ggklass.CrudDTODemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {
    @NotBlank(message = "Name cannot be null/empty or blank")
    private String name;
    @Min(value=18, message = "age is greater than or equal to 18")
    private int age;
    @NotBlank(message = "Email cannot be null/empty or blank")
    @Email(message = "Invalid Email")
    private String email;
    @NotNull(message = "Rollno cannot be null/empty or blank")
    private Integer rollNo;
    @NotBlank(message = "Subject cannot be null/empty or blank")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
