package example.micronaut

import jakarta.inject.Singleton

@Singleton
class TodoService(private val todoRepository: TodoRepo) {
    fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    fun listTodos(): List<Todo> {
        return todoRepository.findAll() as List<Todo>
    }

    fun getTodoById(id: Long): Todo {
        return todoRepository.findById(id).get()
    }

    fun deleteTodoById(id: Long) {
        todoRepository.deleteById(id)
    }

    fun updateTodoById(id: Long, todo: Todo): Todo {
        val todoToUpdate = todoRepository.findById(id).get()
        todoToUpdate.description = todo.description
        todoToUpdate.completed = todo.completed
        return todoRepository.update(todoToUpdate)
    }

    // set todo.completed to the opposite of what it was
    fun toggleTodoById(id: Long): Todo {
        val todoToUpdate = todoRepository.findById(id).get()
        todoToUpdate.completed = !todoToUpdate.completed
        return todoRepository.update(todoToUpdate)
    }


}
