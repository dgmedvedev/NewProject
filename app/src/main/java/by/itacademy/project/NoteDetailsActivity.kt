package by.itacademy.project

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

class NoteDetailsActivity : Activity() {

    val id = intent.getStringExtra("id")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
    }
}