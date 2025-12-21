package org.example.services;

import org.example.dtos.requests.NoteRequest;
import org.example.dtos.responses.NoteResponse;

public interface NoteService {
    NoteResponse createNote(NoteRequest noteRequest);
}
