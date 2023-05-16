package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Get

@Controller("/todos")
class TodoController(private val todoService: TodoService) {
    @Post
    fun createTodo(@Body todo: Todo): Todo {
        return todoService.createTodo(todo)
    }

    @Get
    fun listTodos(): Iterable<Todo> {
        return todoService.listTodos()
    }
}