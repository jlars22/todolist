package example.micronaut

import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = true, length = 500)
    val description: String? = null,

    @Column(nullable = false)
    val completed: Boolean = false
)

