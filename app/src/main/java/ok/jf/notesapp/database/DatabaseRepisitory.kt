package ok.jf.notesapp.database

import androidx.lifecycle.LiveData
import ok.jf.notesapp.model.Note

interface DatabaseRepisitory {

    val readAll : LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)
}