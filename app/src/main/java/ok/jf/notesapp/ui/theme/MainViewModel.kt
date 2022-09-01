package ok.jf.notesapp.ui.theme

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ok.jf.notesapp.database.room.AppRoomDatabase
import ok.jf.notesapp.database.room.repository.RoomRepository
import ok.jf.notesapp.model.Note
import ok.jf.notesapp.utils.REPOSITORY
import ok.jf.notesapp.utils.TYPE_FIREBASE
import ok.jf.notesapp.utils.TYPE_ROOM
import java.lang.IllegalArgumentException

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}