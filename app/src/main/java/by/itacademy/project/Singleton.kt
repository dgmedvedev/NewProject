package by.itacademy.project

import java.util.*
import com.google.gson.Gson

object Singleton {

    private var listNotes: MutableList<Note> = mutableListOf()

    fun getListNotes(): MutableList<Note> {
        return listNotes
    }

    fun getFillListNotes(): MutableList<Note> {
        listNotes = mutableListOf(
            Note("1", "text 1", "header 1"),
            Note("2", "text 2", "header 2"),
            Note("3", "text 3", "header 3")
        )
        return listNotes
    }

    /*
    fun getData(listNotes: MutableList<Note>): MutableList<Note>{
        return if(listNotes.isEmpty())
            getFillListNotes()
        else
            listNotes
    }
    */

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
}