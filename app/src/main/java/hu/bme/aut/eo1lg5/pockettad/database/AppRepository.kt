package hu.bme.aut.eo1lg5.pockettad.database

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.google.android.material.tabs.TabLayout
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

    fun updateSubject(subject: Subject){
        appDao.updateSubject(subject)
    }

    fun deleteSubject(subject: Subject) {
        appDao.deleteToDoBySubId(subject.id)
        appDao.deleteReqBySubId(subject.id)
        appDao.deleteSubject(subject)
    }

    fun addRequirement(requirement: Requirement) {
        appDao.addRequirement(requirement)
    }

    fun updateRequirement(requirement: Requirement) {
        appDao.updateRequirement(requirement)
    }

    fun deleteRequirement(requirement: Requirement) {
        appDao.deleteToDoByReqId(requirement.id)
        appDao.deleteRequirement(requirement)
    }

    fun getReqBySubId(long: Long): LiveData<List<Requirement>> {
        return appDao.getReqBySubId(long)
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

    fun getToDoByReqId(reqId: Long): LiveData<List<ToDo>> {
        return appDao.getToDoByReqId(reqId)
    }
}