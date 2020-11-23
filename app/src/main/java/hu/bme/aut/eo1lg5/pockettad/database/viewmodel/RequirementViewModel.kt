package hu.bme.aut.eo1lg5.pockettad.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hu.bme.aut.eo1lg5.pockettad.database.AppDatabase
import hu.bme.aut.eo1lg5.pockettad.database.AppRepository
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RequirementViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Requirement>>
    private val repository: AppRepository

    init {
        val appDao = AppDatabase.getDatabase(
            application
        ).appDao()
        repository = AppRepository(appDao)
        readAllData = repository.readAllRequirement
    }

    fun addRequirement(requirement: Requirement){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRequirement(requirement)
        }
    }

    fun updateRequirement(requirement: Requirement){
        //to runn different thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRequirement(requirement)
        }
    }

    fun deleteRequirement(requirement: Requirement){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRequirement(requirement)
        }
    }

}