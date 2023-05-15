package example.micronaut

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TodoRepo : CrudRepository<Todo, Long> {

}
