package in.ggklass.auth_service.service;

import in.ggklass.auth_service.model.JwtTokenResponse;
import in.ggklass.auth_service.model.User;
import in.ggklass.auth_service.model.UserDto;
import in.ggklass.auth_service.repository.UserRepository;
import in.ggklass.auth_service.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UserDto createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);
        return new UserDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRoles()
        );
    }


    public JwtTokenResponse generateToken(String username) {
        String token = jwtUtil.generateToken(username);
        JwtTokenResponse jwtTokenResponse = new JwtTokenResponse();
        jwtTokenResponse.setToken(token);
        jwtTokenResponse.setType("Bearer");
        jwtTokenResponse.setValidUntil(jwtUtil.extractExpiration(token).toString());
        return jwtTokenResponse;
    }
}
