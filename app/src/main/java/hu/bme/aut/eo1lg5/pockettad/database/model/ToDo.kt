package hu.bme.aut.eo1lg5.pockettad.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "todo_table")
data class ToDo (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val requirementId: Long?,
    val name: String,
    val description: String,
    //val deadLine: String,
    val done: Boolean
) : Parcelable {}