package hu.bme.aut.eo1lg5.pockettad.database

import androidx.lifecycle.LiveData
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject

class AppRepository(private val appDao: AppDao){

    val readAllSubject: LiveData<List<Subject>> = appDao.getAllSubject()

    suspend fun addSubject(subject: Subject){
        appDao.addSubject(subject)
    }

    suspend fun updateSubject(subject: Subject){
        appDao.updateSubject(subject)
    }
}