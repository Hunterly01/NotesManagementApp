package org.example.controllers;

import org.example.dtos.requests.DeleteNoteRequest;
import org.example.dtos.requests.LockNoteRequest;
import org.example.dtos.requests.NoteRequest;
import org.example.dtos.responses.ApiResponse;
import org.example.exceptions.NoteManagementExceptions;
import org.example.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/Notes")
    public ResponseEntity<?> createNote(@RequestBody NoteRequest noteRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, noteService.createNote(noteRequest)), HttpStatus.CREATED);
        } catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> updateNote(@RequestBody NoteRequest noteRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, noteService.updateNote(noteRequest)), HttpStatus.CREATED);
        }
        catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/notes")
    public ResponseEntity<?> deleteNote(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        try {
            noteService.deleteNote(deleteNoteRequest);
            return ResponseEntity.ok(new ApiResponse(true, "Note deleted successfully"));
        } catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/viewAllNotes")
    public ResponseEntity<?> viewAllNotes( NoteRequest noteRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, noteService.viewAllNotes()), HttpStatus.OK);
        }
        catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/Lock")
    public ResponseEntity<?> lockNote(LockNoteRequest lockNoteRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, noteService.lockNote(lockNoteRequest)), HttpStatus.OK);

        }
        catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/Unlocked")
    public ResponseEntity <?> UnlockNote(LockNoteRequest lockNoteRequest) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, noteService.unlockNote(lockNoteRequest)), HttpStatus.OK);

        }
        catch (NoteManagementExceptions e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
