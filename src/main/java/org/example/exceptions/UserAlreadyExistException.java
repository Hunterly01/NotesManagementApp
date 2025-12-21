package org.example.exceptions;

public class UserAlreadyExistException extends NoteManagementExceptions{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
