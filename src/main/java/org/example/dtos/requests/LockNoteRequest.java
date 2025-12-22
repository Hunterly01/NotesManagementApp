package org.example.dtos.requests;

import lombok.Data;

@Data
public class LockNoteRequest {
    private String password;
    private String noteTitle;
}
