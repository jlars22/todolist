package example.micronaut

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.exceptions.HttpStatusException

@Controller("/todos")
class TodoControllerImpl(private val todoService: TodoService) : TodoController{
    @Post
    override fun createTodo(@Body todo: Todo): Todo {
        return todoService.createTodo(todo)
    }

    @Delete("/{id}")
    override fun deleteTodoById(id: Long): Todo {
        try {
            return todoService.deleteTodoById(id)
        } catch (e: IllegalArgumentException) {
            throw HttpStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

    @Get
    override fun listTodos(): List<Todo> {
        return todoService.listTodos()
    }

    @Get("/{id}")
    override fun getTodoById(id: Long): Todo {
        try {
            return todoService.getTodoById(id)
        } catch (e: IllegalArgumentException) {
            throw HttpStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

    @Patch("/{id}/update")
    override fun updateTodoById(id: Long, @Body todo: Todo): Todo {
        try {
            return todoService.updateTodoById(id, todo)
        } catch (e: IllegalArgumentException) {
            throw HttpStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

    @Patch("/{id}/toggle")
    override fun toggleTodoCompletionById(id: Long): Todo {
        try {
            return todoService.toggleTodoCompletionById(id)
        } catch (e: IllegalArgumentException) {
            throw HttpStatusException(HttpStatus.NOT_FOUND, e.message)
        }
    }

}