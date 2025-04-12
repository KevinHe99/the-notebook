package com.example.notebook.service;

import com.example.notebook.entity.Note;
import com.example.notebook.repository.NoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    // Create
    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    // Read
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }

    public Note updateNote(Long id, Note noteUpdate) {
        Note note = getNoteById(id);
        note.setTitle(noteUpdate.getTitle());
        note.setContent(noteUpdate.getContent());
        note.setUpdatedAt(LocalDateTime.now());
        note.setVersion(note.getVersion() + 1);
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        Note note = getNoteById(id);
        noteRepository.delete(note);
    }


}
