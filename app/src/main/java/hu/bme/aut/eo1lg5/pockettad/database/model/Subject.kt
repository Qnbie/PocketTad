package hu.bme.aut.eo1lg5.pockettad.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "subject_table")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String,
    val description: String,
    val webpage: String,
    val done: Boolean
) : Parcelable