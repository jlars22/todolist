package example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch

@Controller("/todos")
class TodoController(private val todoService: TodoService) {
    @Post
    fun createTodo(@Body todo: Todo): Todo {
        return todoService.createTodo(todo)
    }

    @Delete("/{id}/delete")
    fun deleteTodoById(id: Long): Todo {
        try {
            return todoService.deleteTodoById(id)
        } catch (e: IllegalArgumentException) {
            throw io.micronaut.http.exceptions.HttpStatusException(io.micronaut.http.HttpStatus.NOT_FOUND, e.message)
        }
    }

    @Get
    fun listTodos(): List<Todo> {
        return todoService.listTodos()
    }

    @Get("/{id}")
    fun getTodoById(id: Long): Todo {
        return todoService.getTodoById(id)
    }

    @Patch("/{id}/update")
    fun updateTodoById(id: Long, @Body todo: Todo): Todo {
        return todoService.updateTodoById(id, todo)
    }

    @Patch("/{id}/toggle")
    fun toggleTodoCompletionById(id: Long): Todo {
        return todoService.toggleTodoCompletionById(id)
    }
}