package com.example.notepadushakov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputNote;
    private Button buttonSaveNote;
    private SharedPreferences prefs;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        inputNote = findViewById(R.id.inputNote);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);
        prefs = getSharedPreferences("My Note", MODE_PRIVATE);

        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myEditor = prefs.edit();
                String noteTxt = inputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(MainActivity.this, "Данные сохранены",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDateFromSharedPref(){
        String noteTxt = prefs.getString(NOTE_TEXT, "");
        inputNote.setText(noteTxt);
    }


}
