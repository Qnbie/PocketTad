package hu.bme.aut.eo1lg5.pockettad.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class ReqToSubject (
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "id",
        entityColumn = "subjectId"
    )
    val requirementLists: List<Requirement>
)