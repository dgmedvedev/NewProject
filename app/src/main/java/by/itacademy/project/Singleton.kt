package by.itacademy.project

import java.util.*

object Singleton {

    private var listNotes: MutableList<Note> = mutableListOf()

    fun getListNotes(): MutableList<Note> {
        if(listNotes.isEmpty()) getFillListNotes()

        return listNotes
    }

    fun getFillListNotes() {
        listNotes = mutableListOf(
            Note("1", "text 1", "header 1"),
            Note("2", "text 2", "header 2"),
            Note("3", "text 3", "header 2")
        )
    }



    fun addNotes(note: Note) {
        listNotes.add(note)
    }
    fun getId():String{
        return UUID.randomUUID().toString()
    }

    fun getNoteById(id: String?): Note? {
        return listNotes.find { it.id == id }
    }
}