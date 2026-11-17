package soa.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import soa.dto.RegisterRequest;
import soa.entity.User;
import soa.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(request.username());

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(request.password()));

        // Give every new user the default USER role
        user.setRole("ROLE_USER");

        userRepository.save(user);

        return "User registered successfully";
    }
}