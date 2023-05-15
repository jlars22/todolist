package example.micronaut

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TodoRepository : CrudRepository<Todo, Long> {
    // Define additional methods if needed
}
