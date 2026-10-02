package in.ggklass.auth_service.controller;

import in.ggklass.auth_service.exception.BadRequestException;
import in.ggklass.auth_service.model.JwtTokenResponse;
import in.ggklass.auth_service.model.LoginRequest;
import in.ggklass.auth_service.model.User;
import in.ggklass.auth_service.model.UserDto;
import in.ggklass.auth_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User user) {
        UserDto userDto = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PostMapping("/token")
    public JwtTokenResponse generateToken(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            if(authentication.isAuthenticated()) {
                return userService.generateToken(loginRequest.getUsername());
            }else {
                throw new BadRequestException("Invalid Credentials");
            }
        } catch (Exception e) {
            throw new BadRequestException("Invalid Credentials");
        }
    }
}
