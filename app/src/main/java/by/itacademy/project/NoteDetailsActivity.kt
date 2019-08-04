package by.itacademy.project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class NoteDetailsActivity : Activity() {

    // val id = intent.getStringExtra("id")

    companion object {
        private const val ID_STUDENT = "ID_STUDENT"

        fun getIntent(context: Context, idStudent: String): Intent {
            val intent = Intent(context, NoteDetailsActivity::class.java)
            intent.putExtra(ID_STUDENT, idStudent)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val nameNoteTextView = findViewById<TextView>(R.id.nameNote)
        val textNoteTextView = findViewById<TextView>(R.id.textNote)

        val id = intent.getStringExtra(ID_STUDENT)
        val user: Note? = Singleton.getNoteById(id)

        if (user == null) {
            Toast.makeText(
                this,
                "id not found",
                Toast.LENGTH_SHORT
            ).show()
            this.finish()
        }
        user?.let {
            nameNoteTextView.text = user.name
            textNoteTextView.text = user.text
        }
/*
        edit.setOnClickListener {
            startActivity(Dz6StudentEditActivity.getIntent(this@Dz6StudentDetailsActivity, idStudent))
            this.finish()
        }
        */
    }
}