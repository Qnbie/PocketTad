package hu.bme.aut.eo1lg5.pockettad.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<ToDo>>
    private val repository: AppRepository

    init {
        val appDao = AppDatabase.getDatabase(application).appDao()
        repository = AppRepository(appDao)
        readAllData = repository.readAllToDo
    }

    fun addToDo(toDo: ToDo){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addToDo(toDo)
        }
    }

    fun updateToDo(toDo: ToDo){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateToDo(toDo)
        }
    }

    fun deleteToDo(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteToDo(toDo)
        }
    }

}