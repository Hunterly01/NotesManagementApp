package org.example.services;

import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.example.dtos.responses.LoginResponse;
import org.example.dtos.responses.RegisterResponse;

public interface UserService {
    RegisterResponse registerUser(RegisterRequest registerRequest);
    LoginResponse loginUser(LoginRequest loginRequest);
}
