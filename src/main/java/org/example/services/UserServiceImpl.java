package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.example.dtos.responses.LoginResponse;
import org.example.dtos.responses.RegisterResponse;
import org.example.exceptions.InvalidCredentialException;
import org.example.exceptions.UserAlreadyExistException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.utils.Mapper.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        userRepository.findByEmail(registerRequest.getEmail()).ifPresent(user -> {throw new UserAlreadyExistException("User with email already exists!");
        });
        User user = mapUserRequest(registerRequest);
        User savedUser = userRepository.save(user);
        return mapResponse(savedUser);
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new InvalidCredentialException("User not found"));

        if (!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialException("Invalid credentials");
        }
        return mapLoginResponse(user);
    }
}
