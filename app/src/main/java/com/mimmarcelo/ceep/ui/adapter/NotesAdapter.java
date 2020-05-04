package com.mimmarcelo.ceep.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mimmarcelo.ceep.R;
import com.mimmarcelo.ceep.model.Note;
import com.mimmarcelo.ceep.ui.holder.NoteHolder;
import com.mimmarcelo.ceep.ui.listener.OnItemClickListener;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NoteHolder> {
    private final Context context;
    private final List<Note> notes;
    private OnItemClickListener itemClickListener;

    public NotesAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_notes, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(notes.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void add(Note note) {
        notes.add(note);
        notifyDataSetChanged();
    }

    public Note getItem(int position){
        return notes.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public void update(int position, Note note) {
        notes.set(position, note);
        notifyDataSetChanged();
    }
}
