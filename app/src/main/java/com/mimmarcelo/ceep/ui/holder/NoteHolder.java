package com.mimmarcelo.ceep.ui.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mimmarcelo.ceep.R;
import com.mimmarcelo.ceep.model.Note;
import com.mimmarcelo.ceep.ui.listener.OnItemClickListener;

public class NoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView header;
    private final TextView content;
    private OnItemClickListener onItemClickListener;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        header = itemView.findViewById(R.id.txt_note_header);
        content = itemView.findViewById(R.id.txt_note_content);
        itemView.setOnClickListener(this);
    }

    public void bind(Note note, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        header.setText(note.getHeader());
        content.setText(note.getContent());
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(getAdapterPosition());
    }
}
