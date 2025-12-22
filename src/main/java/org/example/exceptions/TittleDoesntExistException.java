package org.example.exceptions;

public class TittleDoesntExistException extends NoteManagementExceptions{
    public TittleDoesntExistException(String message) {
        super(message);
    }
}
