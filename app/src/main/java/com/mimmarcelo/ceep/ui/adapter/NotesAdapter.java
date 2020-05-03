package com.mimmarcelo.ceep.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mimmarcelo.ceep.R;
import com.mimmarcelo.ceep.model.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {
    private final Context context;
    private final List<Note> notes;

    public NotesAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesAdapter.NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem_notes, parent, false);
        return new NotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void add(Note note) {
        notes.add(note);
        notifyDataSetChanged();
    }

    protected class NotesHolder extends RecyclerView.ViewHolder{

        private final TextView header;
        private final TextView content;

        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.txt_note_header);
            content = itemView.findViewById(R.id.txt_note_content);
        }

        private void bind(Note note){
            header.setText(note.getHeader());
            content.setText(note.getContent());
        }
    }
}
