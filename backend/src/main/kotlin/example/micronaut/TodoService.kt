package example.micronaut

import jakarta.inject.Singleton

@Singleton
class TodoService(private val todoRepository: TodoRepository) {
    fun getAllTodos(): List<Todo> {
        return todoRepository.findAll().toList()
    }

    fun createTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    // Implement other CRUD operations as needed
}
