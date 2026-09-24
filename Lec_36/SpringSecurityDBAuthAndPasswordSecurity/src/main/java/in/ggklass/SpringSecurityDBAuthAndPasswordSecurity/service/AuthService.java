package in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.service;

import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterRequestDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterResponseDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.entity.User;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponseDto register(
            UserRegisterRequestDto registerRequestDto) {

        User user = new User();
        user.setUsername(registerRequestDto.getUsername());

        String encodedPassword =
                passwordEncoder.encode(registerRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        userRepository.save(user);

        UserRegisterResponseDto responseDto = new
                UserRegisterResponseDto();

        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

        return responseDto;

    }

    public Boolean login(UserRegisterRequestDto registerRequestDto) {
        Optional<User> userOptional = userRepository.findByUsername(
                registerRequestDto.getUsername());

        User user = userOptional.get();

        String encodedPassword = user.getPassword();

        return passwordEncoder.matches(
                registerRequestDto.getPassword(),
                encodedPassword
        );
    }
}
