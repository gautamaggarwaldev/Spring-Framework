package in.ggklass.auth_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtTokenResponse {

    private String token;
    private String type;
    private String validUntil;

}
