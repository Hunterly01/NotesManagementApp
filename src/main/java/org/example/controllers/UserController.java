package org.example.controllers;

import org.example.dtos.requests.LoginRequest;
import org.example.dtos.requests.RegisterRequest;
import org.example.dtos.responses.ApiResponse;
import org.example.exceptions.NoteManagementExceptions;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try{
            return new ResponseEntity<>(new ApiResponse(true, userService.registerUser(registerRequest)), HttpStatus.CREATED);

        }
        catch (NoteManagementExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/Login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try{
            return new ResponseEntity<>(new ApiResponse(true, userService.loginUser(loginRequest)), HttpStatus.CREATED);
        }
        catch (NoteManagementExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
