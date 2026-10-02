package in.ggklass.auth_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MissingParameterException extends RuntimeException{
    private String message;
    private HttpStatus statusCode;

    public MissingParameterException(String message) {
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST;
    }
}
