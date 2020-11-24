package hu.bme.aut.eo1lg5.pockettad.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "requirement_table")
data class Requirement (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val subjectId: Long?,
    val name: String,
    val desc: String,
    val deadLine: String,
    var done: Boolean
) : Parcelable