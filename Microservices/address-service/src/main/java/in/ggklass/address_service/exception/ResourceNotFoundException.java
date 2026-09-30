package in.ggklass.address_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String message;
    private HttpStatus statusCode;

    public ResourceNotFoundException(String message) {
        this.message = message;
        this.statusCode = HttpStatus.NOT_FOUND;
    }
}
