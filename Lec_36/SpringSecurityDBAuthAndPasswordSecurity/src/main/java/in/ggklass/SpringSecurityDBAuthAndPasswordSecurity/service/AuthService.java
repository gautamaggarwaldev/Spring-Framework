package in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.service;

import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterRequestDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.dto.UserRegisterResponseDto;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.entity.Role;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.entity.User;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.repository.RoleRepository;
import in.ggklass.SpringSecurityDBAuthAndPasswordSecurity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(
            UserRegisterRequestDto registerRequestDto) {

        User user = new User();
        user.setUsername(registerRequestDto.getUsername());

        String encodedPassword =
                passwordEncoder.encode(registerRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByRole("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto responseDto = new
                UserRegisterResponseDto();

        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

        return responseDto;

    }
}
