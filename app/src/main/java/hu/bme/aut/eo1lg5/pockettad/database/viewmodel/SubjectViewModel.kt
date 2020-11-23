package hu.bme.aut.eo1lg5.pockettad.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hu.bme.aut.eo1lg5.pockettad.database.AppDatabase
import hu.bme.aut.eo1lg5.pockettad.database.AppRepository
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Subject>>
    private val repository: AppRepository

    init {
        val appDao = AppDatabase.getDatabase(
            application
        ).appDao()
        repository = AppRepository(appDao)
        readAllData = repository.readAllSubject
    }

    fun addSubject(subject: Subject){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSubject(subject)
        }
    }

    fun updateSubject(subject: Subject){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSubject(subject)
        }
    }

    fun deleteSubject(subject: Subject){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSubject(subject)
        }
    }

}
