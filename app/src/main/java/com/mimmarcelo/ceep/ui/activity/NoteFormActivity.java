package com.mimmarcelo.ceep.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mimmarcelo.ceep.M;
import com.mimmarcelo.ceep.R;
import com.mimmarcelo.ceep.model.Note;

public class NoteFormActivity extends AppCompatActivity {

    private TextView edtHeader;
    private TextView edtContent;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);

        edtHeader = findViewById(R.id.edt_note_header);
        edtContent = findViewById(R.id.edt_note_content);
        position = getIntent().getIntExtra(M.extra.position, -1);

        if(getIntent().hasExtra(M.extra.note_obj)){
            Note note = (Note) getIntent().getSerializableExtra(M.extra.note_obj);
            edtHeader.setText(note.getHeader());
            edtContent.setText(note.getContent());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Note note = new Note(edtHeader.getText().toString(), edtContent.getText().toString());
        Intent intent = new Intent();
        intent.putExtra(M.extra.note_obj, note);
        intent.putExtra(M.extra.position, position);
        setResult(RESULT_OK, intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
