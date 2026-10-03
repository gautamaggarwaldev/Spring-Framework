package in.ggklass.address_service.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import in.ggklass.address_service.exception.BadRequestException;
import in.ggklass.address_service.exception.CustomException;
import in.ggklass.address_service.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        int status = response.status();

        if(status==503) {
            throw new BadRequestException("Address service is down.Please try again later.", HttpStatus.SERVICE_UNAVAILABLE);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try(InputStream is = response.body().asInputStream()) {
            ErrorResponse errorResponse = objectMapper.readValue(is, ErrorResponse.class);

            return new CustomException(errorResponse.getMessage(), errorResponse.getStatusCode());
        }
        catch(IOException e) {
            throw new CustomException("Employee is not present");
        }
    }
}
