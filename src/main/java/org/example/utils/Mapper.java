package org.example.utils;

import org.example.data.models.User;
import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.example.dtos.responses.LoginResponse;
import org.example.dtos.responses.RegisterResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;

public class Mapper {
   public static User mapUserRequest (RegisterRequest registerRequest) {
       User user = new User();
       user.setEmail(registerRequest.getEmail());
       user.setFirstName(registerRequest.getFirstName());
       user.setLastName(registerRequest.getLastName());
       user.setDate(LocalDateTime.now());
       String hashedPassword = BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt(12));
       user.setPassword(hashedPassword);
       return user;
   }

    public static RegisterResponse mapResponse(User savedUser) {
       RegisterResponse response = new RegisterResponse();
       response.setMessage("Registered Successfully");
       return response;
    }


    public static LoginResponse mapLoginResponse(User savedUser) {
       LoginResponse response = new LoginResponse();
       response.setMessage("Login Successfully");
       response.setEmail(savedUser.getEmail());
       return response;
    }
}
