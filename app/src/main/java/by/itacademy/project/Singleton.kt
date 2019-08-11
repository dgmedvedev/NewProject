package by.itacademy.project

import com.google.gson.Gson
import java.util.Arrays
import java.util.UUID

object Singleton {

    private var listNotes: MutableList<Note> = mutableListOf()

    fun getListNotes(): MutableList<Note> {
        return listNotes
    }

    fun setListNotes(list: MutableList<Note>){
        this.listNotes = list
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

    fun listFromJson(listJson: String): MutableList<Note>{
        val arraysListFromJson = stringToArray(listJson, Array<Note>::class.java)
        val listFromJson = mutableListOf<Note>()

        for (arrayNotes in arraysListFromJson) {
            for(note in arrayNotes)
                listFromJson.add(note)
        }
        return listFromJson
    }

    private fun <T> stringToArray(string: String, clazz: Class<Array<T>>): MutableList<Array<T>> {
        val arr = Gson().fromJson(string, clazz)
        return Arrays.asList(arr)
    }
}