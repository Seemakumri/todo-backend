package com.todo.management.service;

import com.todo.management.entity.Note;
import com.todo.management.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note note) {

        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note Not Found"));

        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());

        return noteRepository.save(existingNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}