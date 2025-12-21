package org.example.dtos.responses;

import lombok.Data;

@Data
public class NoteResponse {
    private String id;
    private String title;
    private String content;
}
