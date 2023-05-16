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

    fun deleteTodoById(id: Long) : Todo {
        val todo = todoRepository.findById(id)
        if (todo.isEmpty) {
            throw IllegalArgumentException("No todo found with id $id")
        }
        todoRepository.deleteById(id)
        return todo.get()
    }

    fun updateTodoById(id: Long, todo: Todo): Todo {
        val todoToUpdate = todoRepository.findById(id).get()
        todoToUpdate.description = todo.description
        return todoRepository.update(todoToUpdate)
    }

    fun toggleTodoCompletionById(id: Long): Todo {
        val todoToUpdate = todoRepository.findById(id).get()
        todoToUpdate.completed = !todoToUpdate.completed
        return todoRepository.update(todoToUpdate)
    }


}
