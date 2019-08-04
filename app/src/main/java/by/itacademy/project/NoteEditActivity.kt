package by.itacademy.project

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.edit_activity.*

class NoteEditActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_activity)

        val nameNoteEditText = findViewById<EditText>(R.id.nameNoteEditText)
        val textNoteEditText = findViewById<EditText>(R.id.textNoteEditText)


        saveButton.setOnClickListener {
            val newNotes = Note(
                Singleton.getId(),
                textNoteEditText.text.toString(),
                nameNoteEditText.text.toString()
            )
            Singleton.addNotes(newNotes)
            onBackPressed()
        }

        
    }
}