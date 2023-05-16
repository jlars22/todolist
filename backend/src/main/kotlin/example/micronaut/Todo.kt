package example.micronaut

import javax.persistence.*

@Entity
@Table(name= "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val description: String,
    val completed: Boolean
) {
    constructor() : this(0, "", false)
}



