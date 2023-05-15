package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body

@Controller("/todos")
class TodoController(private val todoService: TodoService) {
    @Post
    fun createTodo(@Body todo: Todo): Todo {
        return todoService.createTodo(todo)
    }
}