package in.ggklass.employee_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import in.ggklass.employee_service.exception.CustomException;
import in.ggklass.employee_service.exception.ErrorResponse;

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
            throw new CustomException("INTERNAL_SERVER_ERROR");
        }
    }
}
