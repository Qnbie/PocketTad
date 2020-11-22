package hu.bme.aut.eo1lg5.pockettad.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo_table")
data class ToDo (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val requirementId: Long?,
    val name: String,
    val description: String,
    //val deadLine: Date?,
    val done: Boolean
){}