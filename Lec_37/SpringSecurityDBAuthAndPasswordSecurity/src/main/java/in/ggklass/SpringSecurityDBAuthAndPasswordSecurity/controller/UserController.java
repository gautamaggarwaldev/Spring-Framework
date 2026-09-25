package in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.controller;

import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterRequestDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterResponseDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(Authentication authentication) {
        return "Hello, you are logged in as " + authentication.getName() ;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto registerRequestDto) {
        UserRegisterResponseDto userRegisterResponseDto
                = authService.register(registerRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);
    }

}
