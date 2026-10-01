package in.ggklass.address_service.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import in.ggklass.address_service.exception.CustomException;
import in.ggklass.address_service.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
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
