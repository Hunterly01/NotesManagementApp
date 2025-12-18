package org.example.data.repositories;

import org.example.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NoteRepository  extends MongoRepository<Note, String> {
    Optional<Note> findByTitle(String title);
}
