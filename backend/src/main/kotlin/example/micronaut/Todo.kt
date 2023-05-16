package example.micronaut

import javax.persistence.*

@Entity
@Table(name= "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var description: String,
    var completed: Boolean
) {
    constructor() : this(0, "", false)
}



