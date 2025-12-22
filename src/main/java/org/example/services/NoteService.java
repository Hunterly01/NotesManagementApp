package org.example.services;

import org.example.dtos.requests.LockNoteRequest;
import org.example.dtos.requests.NoteRequest;
import org.example.dtos.responses.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(NoteRequest noteRequest);
    NoteResponse updateNote(NoteRequest noteRequest);
    void deleteNote(String tittle);
    List<NoteResponse> viewAllNotes();
    NoteResponse lockNote(LockNoteRequest lockNoteRequest);
    NoteResponse unlockNote(LockNoteRequest lockNoteRequest);
}
