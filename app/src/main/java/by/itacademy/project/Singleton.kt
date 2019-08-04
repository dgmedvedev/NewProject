package by.itacademy.project

object Singleton {

    private var listNotes: List<Note> = listOf(
        Note("1", "text 1", "header 1"),
        Note("2", "text 2", "header 2"),
        Note("3", "text 3", "header 2")
    )

    fun getListNotes(): List<Note> {
        return listNotes
    }

    fun getFillListNotes(): List<Note> {
        listNotes = mutableListOf(
            Note("1", "text 1", "header 1"),
            Note("2", "text 2", "header 2"),
            Note("3", "text 3", "header 2")
        )
        return listNotes
    }
/*
    fun addNotes(note: Note) {
        val index = listNotes.indexOfFirst { it.id == note.id }

        if (index != -1) {
            listNotes[index] = note
        } else {
            listNotes.add(note)
        }
    }
*/
    fun getNoteById(id: String): Note? {
        return listNotes.find { it.id == id }
    }
}