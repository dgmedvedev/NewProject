package by.itacademy.project

import java.util.*
import com.google.gson.Gson

object Singleton {

    private var listNotes: MutableList<Note> = mutableListOf()

    fun getFillListNotes(): MutableList<Note> {
        return listNotes
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

    fun deleteNote(id: String){
        listNotes.remove(getNoteById(id))
    }

    fun listToJson(): String{
        return Gson().toJson(listNotes)
    }
    fun runn(){

    }
}