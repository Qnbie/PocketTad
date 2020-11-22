package hu.bme.aut.eo1lg5.pockettad.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "requirements")
data class Requirement (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val subjectId: Long?,
    val name: String,
    val desc: String,
    //val deadLine: Date,
    val done: Boolean
)