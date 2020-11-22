package hu.bme.aut.eo1lg5.pockettad.database.model

import androidx.room.Embedded
import androidx.room.Relation

class ToDoToReq (
    @Embedded
    val requirement: Requirement,
    @Relation(
        parentColumn = "id",
        entityColumn = "reqId"
    )
    val todoLists: List<ToDo>
)