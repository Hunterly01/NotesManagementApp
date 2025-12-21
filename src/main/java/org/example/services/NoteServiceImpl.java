package org.example.services;

import org.example.data.models.Note;
import org.example.data.repositories.NoteRepository;
import org.example.dtos.requests.NoteRequest;
import org.example.dtos.responses.NoteResponse;
import org.example.exceptions.TittleAlreadyExistException;
import org.example.exceptions.TittleDoesntExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.example.utils.Mapper.mapNoteRequest;
import static org.example.utils.Mapper.mapNoteResponse;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteResponse createNote(NoteRequest noteRequest) {
        noteRepository.findByTitle(noteRequest.getTitle()).ifPresent(note -> {throw new TittleAlreadyExistException("Note with title already exists!");
        });
        Note note = mapNoteRequest(noteRequest);
        Note savedNote = noteRepository.save(note);
        return mapNoteResponse(savedNote);
    }

    @Override
    public NoteResponse updateNote(NoteRequest noteRequest) {
        Note existingNote = noteRepository.findByTitle(noteRequest.getTitle()).orElseThrow(() -> new TittleDoesntExistException("Note with title doesn't exist!"));
        existingNote.setContent(noteRequest.getContent());
        existingNote.setTitle(noteRequest.getTitle());
        existingNote.setDescription(noteRequest.getDescription());
        Note savedNote = noteRepository.save(existingNote);
        return mapNoteResponse(savedNote);
    }

    @Override
    public void deleteNote(String tittle) {
        Note note = noteRepository.findByTitle(tittle).orElseThrow(() -> new TittleDoesntExistException("Note with title doesn't exist!"));
        noteRepository.delete(note);
    }

    @Override
    public List<NoteResponse> viewAllNotes() {
        List<Note> notes = noteRepository.findAll();
        List<NoteResponse> noteResponses = new ArrayList<>();
        for (Note note : notes) {
            noteResponses.add(mapNoteResponse(note));
        }
        return noteResponses;
    }
}
