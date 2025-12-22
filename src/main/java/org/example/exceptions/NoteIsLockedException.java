package org.example.exceptions;

public class NoteIsLockedException extends NoteManagementExceptions{
    public NoteIsLockedException(String message) {
        super(message);
    }
}
