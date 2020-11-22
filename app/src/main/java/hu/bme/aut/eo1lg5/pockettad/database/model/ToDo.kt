package hu.bme.aut.eo1lg5.pockettad.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDo (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String,
    val description: String,
    val done: Boolean
){}