package in.ggklass.employee_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private String message;
    private HttpStatus statusCode;

    public CustomException(String message) {
        this.message = message;
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
