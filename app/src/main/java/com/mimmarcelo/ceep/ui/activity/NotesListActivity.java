package com.mimmarcelo.ceep.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mimmarcelo.ceep.R;
import com.mimmarcelo.ceep.dao.NotesDao;
import com.mimmarcelo.ceep.model.Note;
import com.mimmarcelo.ceep.ui.adapter.NotesAdapter;

import java.util.List;

public class NotesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        NotesDao dao = new NotesDao();
        dao.load(new Note("Teste", "Testando..."), new Note("Coração", "Mon Amour!"));
        
        List<Note> notes = dao.all();

        RecyclerView recyclerView = findViewById(R.id.rcv_notes_list);
        recyclerView.setAdapter(new NotesAdapter(this, notes));
    }
}
