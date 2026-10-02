package in.ggklass.auth_service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private String message;
    private HttpStatus statusCode;
    private LocalDateTime dateTime;

    public ErrorResponse(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.dateTime = LocalDateTime.now();
    }
}
