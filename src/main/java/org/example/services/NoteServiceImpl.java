package org.example.services;

import org.example.data.models.Note;
import org.example.data.repositories.NoteRepository;
import org.example.dtos.requests.NoteRequest;
import org.example.dtos.responses.NoteResponse;
import org.example.exceptions.TittleAlreadyExistException;
import org.example.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
