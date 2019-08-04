package by.itacademy.project.network

import by.itacademy.project.Note
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE

interface NotesApi {

    @GET("data/note") // остальную часть допишет retrofit
    fun getNotes(
        @Query("pageSize") pageSize: Int // дописывает с помощью @Query
    ): Observable<MutableList<Note>>

    @GET("data/note/{objectId}")
    fun getNoteById(
        @Path("objectId") id: String
    ): Observable<Note>

    @GET("data/note")
    fun searchByName(
        @Query("pageSize") pageSize: Int,
        @Query("offset") offset: Int,
        @Query("where") state: String
    ): Observable<MutableList<Note>>

    @POST("data/note")
    fun addNote(
        @Body note: Note
    ): Observable<Note>

    @PUT("data/note/{objectId}")
    fun updateNote(
        @Path("objectId") id: String,
        @Body note: Note
    ): Completable

    @DELETE("data/note/{objectId}")
    fun deleteNote(
        @Path("objectId") id: String
    ): Completable
}