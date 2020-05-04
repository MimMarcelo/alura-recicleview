package com.mimmarcelo.ceep.ui.callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.mimmarcelo.ceep.dao.NotesDao;
import com.mimmarcelo.ceep.ui.adapter.NotesAdapter;

public class NotaCallback extends ItemTouchHelper.Callback {

    private final NotesAdapter adapter;
    private final NotesDao dao;
    public NotaCallback(NotesAdapter adapter) {
        this.adapter = adapter;
        dao = new NotesDao();
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        dao.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        adapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        dao.remove(viewHolder.getAdapterPosition());
        adapter.remove(viewHolder.getAdapterPosition());
    }
}
