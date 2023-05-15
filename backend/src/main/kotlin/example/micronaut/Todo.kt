package example.micronaut

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "todos")
data class Todo(
    @Id
    val id: Long,
    val title: String,
    val description: String?,
    val completed: Boolean
) {
    constructor() : this(0, "", "", false)
}


