package com.example.notebook.controller.v1;

import com.example.notebook.entity.Note;
import com.example.notebook.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Read: all notes
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }
    // > : by id
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    // Create: a new note
    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    // Update: an existing note
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        return ResponseEntity.ok(noteService.updateNote(id, note));
    }

    // Delete: an existing note
    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

}
