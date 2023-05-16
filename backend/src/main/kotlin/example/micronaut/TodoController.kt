package example.micronaut

import io.micronaut.http.annotation.*

interface TodoController {

    fun createTodo(@Body todo: Todo): Todo

    fun deleteTodoById(id: Long): Todo

    fun listTodos(): List<Todo>

    fun getTodoById(id: Long): Todo

    fun updateTodoById(id: Long, @Body todo: Todo): Todo

    fun toggleTodoCompletionById(id: Long): Todo
}