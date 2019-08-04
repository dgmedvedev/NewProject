package by.itacademy.project.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.project.Note
import by.itacademy.project.R


class Holder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameNote = itemView.findViewById<TextView>(R.id.headerItem)
    private val textNote = itemView.findViewById<TextView>(R.id.descriptionItem)

    fun bind(note: Note) {
        nameNote.text = note.name
        textNote.text = note.text
    }
}