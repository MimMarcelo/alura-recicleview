package com.mimmarcelo.ceep.dao;

import com.mimmarcelo.ceep.model.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NotesDao {
    private final static ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> all() {
        return (ArrayList<Note>) notes.clone();
    }

    public void load(Note... notesList){
        notes.addAll(Arrays.asList(notesList));
    }

    public void add(Note note){
        notes.add(note);
    }

    public void update(int position, Note note){
        notes.set(position, note);
    }

    public void remove(int position){
        remove(notes.get(position));
    }

    public void remove(Note note){
        notes.remove(note);
    }

    public void removeAll(){
        notes.clear();
    }

    public void swap(int firstIndex, int secondIndex){
        Collections.swap(notes, firstIndex, secondIndex);
    }
}
