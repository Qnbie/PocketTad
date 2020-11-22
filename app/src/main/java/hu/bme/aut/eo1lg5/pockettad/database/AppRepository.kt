package hu.bme.aut.eo1lg5.pockettad.database

import androidx.lifecycle.LiveData
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo

class AppRepository(private val appDao: AppDao){

    val readAllToDo: LiveData<List<ToDo>> = appDao.getAllToDo()
    val readAllRequirement: LiveData<List<Requirement>> = appDao.getAllReq()
    val readAllSubject: LiveData<List<Subject>> = appDao.getAllSubject()

    suspend fun addSubject(subject: Subject){
        appDao.addSubject(subject)
    }

    suspend fun updateSubject(subject: Subject){
        appDao.updateSubject(subject)
    }

    fun deleteSubject(subject: Subject) {
        appDao.deleteSubject(subject)
    }

    fun addRequirement(requirement: Requirement) {
        appDao.addRequirement(requirement)
    }

    fun updateRequirement(requirement: Requirement) {
        appDao.updateRequirement(requirement)
    }

    fun deleteRequirement(requirement: Requirement) {
        appDao.deleteRequirement(requirement)
    }

    fun addToDo(toDo: ToDo) {
        appDao.addToDo(toDo)
    }

    fun updateToDo(toDo: ToDo ) {
        appDao.updateToDo(toDo)
    }

    fun deleteToDo(toDo: ToDo) {
        appDao.deleteToDo(toDo)
    }
}