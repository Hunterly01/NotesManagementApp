package org.example.dtos.requests;

import lombok.Data;

@Data
public class NoteRequest {
    private String id;
    private String title;
    private String description;
    private String content;
}
