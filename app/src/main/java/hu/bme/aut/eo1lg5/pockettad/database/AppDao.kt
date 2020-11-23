package hu.bme.aut.eo1lg5.pockettad.database

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.bme.aut.eo1lg5.pockettad.database.model.Requirement
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo

@Dao
interface AppDao {

    //Subject
    @Query("SELECT * FROM subject_table")
    fun getAllSubject(): LiveData<List<Subject>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSubject(subject: Subject): Long
    @Update
    fun updateSubject(subject: Subject)
    @Delete
    fun deleteSubject(subject: Subject?)

    //Requirement
    @Query("SELECT * FROM requirement_table")
    fun getAllReq(): LiveData<List<Requirement>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRequirement(requirement: Requirement): Long
    @Update
    fun updateRequirement(requirement: Requirement)
    @Delete
    fun deleteRequirement(requirement: Requirement)

    //Toods
    @Query("SELECT * FROM todo_table")
    fun getAllToDo(): LiveData<List<ToDo>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToDo(todo: ToDo): Long
    @Update
    fun updateToDo(todo: ToDo)
    @Delete
    fun deleteToDo(todo: ToDo)
}