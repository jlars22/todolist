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

    @Post("/{id}/delete")
    fun deleteTodoById(id: Long) {
        todoService.deleteTodoById(id)
    }

    @Get
    fun listTodos(): List<Todo> {
        return todoService.listTodos()
    }

    @Get("/{id}")
    fun getTodoById(id: Long): Todo {
        return todoService.getTodoById(id)
    }

    @Post("/{id}/update")
    fun updateTodoById(id: Long, @Body todo: Todo): Todo {
        return todoService.updateTodoById(id, todo)
    }

    @Post("/{id}/toggle")
    fun toggleTodoById(id: Long): Todo {
        return todoService.toggleTodoById(id)
    }
}