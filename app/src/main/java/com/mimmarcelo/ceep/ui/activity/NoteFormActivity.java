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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView header = findViewById(R.id.edt_note_header);
        TextView content = findViewById(R.id.edt_note_content);
        Note note = new Note(header.getText().toString(), content.getText().toString());
        Intent intent = new Intent();
        intent.putExtra(M.extra.note_obj, note);
        setResult(RESULT_OK, intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
