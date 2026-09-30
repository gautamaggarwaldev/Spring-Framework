package in.ggklass.address_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends RuntimeException{

    private String message;
    private HttpStatus statusCode;

    public BadRequestException(String message) {
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST;
    }
}
